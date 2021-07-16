package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.RunModel
import io.github.fullstacktester.testrail.TestRailRequest

class Runs {

    fun getRun(runId: Int): RunModel {
        Preconditions.condition(runId > 0, "runId should be positive")
        val request = TestRailRequest("GET", "get_run/${runId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getRuns(projectId: Int): List<RunModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_runs/${projectId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addRun(projectId: Int, run: RunModel): RunModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("POST", "add_run/${projectId}", Json.encodeToString(run))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun updateRun(run: RunModel): RunModel {
        val request = TestRailRequest("POST", "update_run/${run.id}", Json.encodeToString(run))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun closeRun(runId: Int): RunModel {
        Preconditions.condition(runId > 0, "runId should be positive")
        val request = TestRailRequest("POST", "close_run/${runId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun deleteRun(runId: Int) {
        Preconditions.condition(runId > 0, "runId should be positive")
        val request = TestRailRequest("POST", "delete_run/${runId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}