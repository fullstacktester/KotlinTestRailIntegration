package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.TestModel
import io.github.fullstacktester.testrail.TestRailRequest

class Tests {

    fun getTest(testId: Int): TestModel {
        Preconditions.condition(testId > 0, "testId should be positive")
        val request = TestRailRequest("GET", "get_test/${testId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getTests(runId: Int): List<TestModel> {
        Preconditions.condition(runId > 0, "runId should be positive")
        val request = TestRailRequest("GET", "get_tests/${runId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}