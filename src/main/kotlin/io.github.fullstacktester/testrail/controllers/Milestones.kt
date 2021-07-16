package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.MilestoneModel
import io.github.fullstacktester.testrail.TestRailRequest

class Milestones {

    fun getMilestone(milestoneId: Int): MilestoneModel {
        Preconditions.condition(milestoneId > 0, "milestoneId should be positive")
        val request = TestRailRequest("GET", "get_milestone/${milestoneId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getMilestones(projectId: Int): List<MilestoneModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_milestones/${projectId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addMilestone(projectId: Int, milestone: MilestoneModel): MilestoneModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("POST", "add_milestone/${projectId}", Json.encodeToString(milestone))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun updateMilestone(milestone: MilestoneModel): MilestoneModel {
        val request = TestRailRequest("POST", "update_milestone/${milestone.id}", Json.encodeToString(milestone))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun deleteMilestone(milestoneId: Int) {
        val request = TestRailRequest("POST", "delete_milestone/${milestoneId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}