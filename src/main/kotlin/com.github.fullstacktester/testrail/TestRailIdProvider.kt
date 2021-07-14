package com.github.fullstacktester.testrail

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ExtensionContext.Store.CloseableResource
import org.junit.jupiter.api.extension.TestWatcher
import com.github.fullstacktester.testrail.models.ResultModel

import java.util.*


class TestRailIdProvider : TestWatcher, BeforeAllCallback {
    override fun testDisabled(extensionContext: ExtensionContext, optional: Optional<String>) {
        addResult(extensionContext, TestRailStatus.UNTESTED)
    }

    override fun testSuccessful(extensionContext: ExtensionContext) {
        addResult(extensionContext, TestRailStatus.PASSED)
    }

    override fun testAborted(extensionContext: ExtensionContext, throwable: Throwable) {
        addResult(extensionContext, TestRailStatus.RETEST)
    }

    override fun testFailed(extensionContext: ExtensionContext, throwable: Throwable) {
        addResult(extensionContext, TestRailStatus.FAILED)
    }

    @Throws(Exception::class)
    override fun beforeAll(extensionContext: ExtensionContext) {
        if (!started) {
            getStore(extensionContext).put(TESTRAIL_REPORT, CloseableOnlyOnceResource())
            started = true
        }
    }

    private class CloseableOnlyOnceResource : CloseableResource {
        override fun close() {
            TestRailReport.reportResults()
        }
    }

    private fun addResult(extensionContext: ExtensionContext, status: TestRailStatus) {
        if (extensionContext.element.isPresent
                && extensionContext.element.get().isAnnotationPresent(ReportToTestRail::class.java)) {
            val element = extensionContext.element.get().getAnnotation(ReportToTestRail::class.java)

            if (element.id == "UNDEFINED" || element.id.toIntOrNull() == null) {
                throw TestIdException("Test ID must be provided and be an integer. Test ID was: $element.id")
            }

            val result = ResultModel(
                    testId = element.id.toInt(),
                    statusId = status.id,
                    caseId = element.id.toInt())

            TestRailReport.addResult(result)
        }
    }

    private fun getStore(context: ExtensionContext): ExtensionContext.Store {
        return context.root.getStore(ExtensionContext.Namespace.GLOBAL)
    }

    companion object {
        private var started = false
        private const val TESTRAIL_REPORT = "TEST_RAIL"
    }
}