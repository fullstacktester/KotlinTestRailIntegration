package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import com.github.fullstacktester.testrail.TestRailHttp
import com.github.fullstacktester.testrail.models.EntryModel
import com.github.fullstacktester.testrail.models.PlanModel
import com.github.fullstacktester.testrail.TestRailRequest

class Plans {

    fun getPlan(planId: Int): PlanModel {
        Preconditions.condition(planId > 0, "planId should be positive")
        val request = TestRailRequest("GET", "get_plan/${planId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getPlans(projectId: Int): List<PlanModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_plans/${projectId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addPlan(projectId: Int, plan: PlanModel): PlanModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("POST", "add_plan/${projectId}", Json.encodeToString(plan))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun updatePlan(plan: PlanModel): PlanModel {
        val request = TestRailRequest("POST", "update_plan/${plan.id}", Json.encodeToString(plan))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun closePlan(planId: Int): PlanModel {
        Preconditions.condition(planId > 0, "planId should be positive")
        val request = TestRailRequest("POST", "close_plan/${planId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun deletePlan(planId: Int) {
        Preconditions.condition(planId > 0, "planId should be positive")
        val request = TestRailRequest("POST", "delete_plan/${planId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addEntry(planId: Int, entry: EntryModel): EntryModel {
        Preconditions.condition(planId > 0, "planId should be positive")
        val request = TestRailRequest("POST", "add_plan_entry/${planId}", Json.encodeToString(entry))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun updateEntry(planId: Int, entry: EntryModel): EntryModel {
        Preconditions.condition(planId > 0, "planId should be positive")
        val request = TestRailRequest("POST", "update_plan_entry/${planId}/${entry.id}", Json.encodeToString(entry))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun deleteEntry(planId: Int, entryId: String) {
        Preconditions.condition(planId > 0, "planId should be positive")
        Preconditions.condition(entryId.isNotEmpty(), "entryId should have a value")
        val request = TestRailRequest("POST", "delete_plan_entry/${planId}/${entryId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}