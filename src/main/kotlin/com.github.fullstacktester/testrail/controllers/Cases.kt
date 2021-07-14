package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import com.github.fullstacktester.testrail.TestRailHttp.Companion.execute
import com.github.fullstacktester.testrail.TestRailRequest
import com.github.fullstacktester.testrail.models.CaseModel

class Cases {

    fun getCase(testCaseId: Int): CaseModel {
        Preconditions.condition(testCaseId > 0, "testCaseId should be positive")
        val request = TestRailRequest("GET", "get_case/${testCaseId}")

        return Json.decodeFromString(execute(request))
    }

    fun getCases(projectId: Int): List<CaseModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_cases/${projectId}")

        return Json.decodeFromString(execute(request))
    }

    fun getCasesForSuite(projectId: Int, suiteId: Int): List<CaseModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        Preconditions.condition(suiteId > 0, "suiteId should be positive")

        val request = TestRailRequest("GET", "get_cases/${projectId}&suiteId=${suiteId}")

        return Json.decodeFromString(execute(request))
    }

    fun addCase(sectionId: Int, testCase: CaseModel): CaseModel {
        Preconditions.condition(sectionId > 0, "projectId should be positive")

        val request = TestRailRequest("POST", "add_case/${sectionId}", Json.encodeToString(testCase))

        return Json.decodeFromString(execute(request))
    }

    fun updateCase(testCase: CaseModel): CaseModel {
        val request = TestRailRequest("POST", "update_case/${testCase.id}", Json.encodeToString(testCase))

        return Json.decodeFromString(execute(request))
    }

    fun deleteCase(testCaseId: Int) {
        Preconditions.condition(testCaseId > 0, "testCaseId should be positive")
        val request = TestRailRequest("POST", "delete_case/${testCaseId}")

        execute(request)
    }
}