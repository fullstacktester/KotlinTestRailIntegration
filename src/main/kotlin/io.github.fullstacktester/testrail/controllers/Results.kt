package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.ResultModel
import io.github.fullstacktester.testrail.models.ResultsModel
import io.github.fullstacktester.testrail.models.serializers.ResultFieldSerializer
import io.github.fullstacktester.testrail.TestRailRequest

class Results {

    fun getResults(testId: Int): List<ResultModel> {
        Preconditions.condition(testId > 0, "testId should be positive")
        val request = TestRailRequest("GET", "get_results/${testId}/")

        return Json.decodeFromString(ListSerializer(ResultFieldSerializer), TestRailHttp.execute(request))
    }

    fun getResultsForCase(runId: Int, testCaseId: Int): List<ResultModel> {
        Preconditions.condition(runId > 0, "runId should be positive")
        Preconditions.condition(testCaseId > 0, "testCaseId should be positive")
        val request = TestRailRequest("GET", "get_results_for_case/${runId}/${testCaseId}")

        return Json.decodeFromString(ListSerializer(ResultFieldSerializer), TestRailHttp.execute(request))
    }

    fun getResultsForRun(runId: Int): List<ResultModel> {
        Preconditions.condition(runId > 0, "runId should be positive")
        val request = TestRailRequest("GET", "get_results_for_run/${runId}/")

        return Json.decodeFromString(ListSerializer(ResultFieldSerializer), TestRailHttp.execute(request))
    }

    fun addResult(testId: Int, result: ResultModel): ResultModel {
        Preconditions.condition(testId > 0, "testId should be positive")
        val request = TestRailRequest("POST", "add_result/${testId}/", Json.encodeToString(result))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addResultForCase(runId: Int, testCaseId: Int, result: ResultModel): ResultModel {
        Preconditions.condition(runId > 0, "runId should be positive")
        Preconditions.condition(testCaseId > 0, "testCaseId should be positive")
        val request = TestRailRequest("POST", "add_result_for_case/${runId}/${testCaseId}", Json.encodeToString(result))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addResults(runId: Int, results: List<ResultModel>): List<ResultModel> {
        Preconditions.condition(runId > 0, "runId should be positive")
        Preconditions.condition(results.isNotEmpty(), "results cannot be empty")
        val request = TestRailRequest("POST", "add_results/${runId}", Json.encodeToString(results))

        return Json.decodeFromString(ListSerializer(ResultFieldSerializer), TestRailHttp.execute(request))
    }

    fun addResultsForCases(runId: Int, results: ResultsModel): List<ResultModel> {
        Preconditions.condition(runId > 0, "runId should be positive")
        Preconditions.condition(results.results.isNotEmpty(), "results cannot be empty")
        val request = TestRailRequest("POST", "add_results_for_cases/${runId}", Json.encodeToString(results))

        return Json.decodeFromString(ListSerializer(ResultFieldSerializer), TestRailHttp.execute(request))
    }
}