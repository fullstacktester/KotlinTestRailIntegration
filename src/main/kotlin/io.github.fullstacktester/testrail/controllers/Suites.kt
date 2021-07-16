package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.SuiteModel
import io.github.fullstacktester.testrail.TestRailRequest

class Suites {

    fun getSuite(suiteId: Int): SuiteModel {
        Preconditions.condition(suiteId > 0, "suiteId should be positive")
        val request = TestRailRequest("GET", "get_suite/${suiteId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getSuites(projectId: Int): List<SuiteModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_suites/${projectId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addSuite(projectId: Int, suite: SuiteModel): SuiteModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("POST", "add_suite/${projectId}", Json.encodeToString(suite))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun updateSuite(suite: SuiteModel): SuiteModel {
        val request = TestRailRequest("POST", "update_suite/${suite.id}", Json.encodeToString(suite))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun deleteSuite(suiteId: Int) {
        Preconditions.condition(suiteId > 0, "suiteId should be positive")
        val request = TestRailRequest("POST", "delete_suite/${suiteId}")

        TestRailHttp.execute(request)
    }
}