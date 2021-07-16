package io.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import io.github.fullstacktester.testrail.TestRailModel

@Serializable
data class PlanModel(
        val id: Int = 0,
        val name: String? = null,
        val description: String? = null,
        val url: String? = null,
        @SerialName("project_id")
        val projectId: Int = 0,
        @SerialName("milestone_id")
        val milestoneId: Int? = null,
        @SerialName("assignedto_id")
        val assignedToId: Int? = null,
        @SerialName("created_on")
        val createdOn: Long? = null,
        @SerialName("created_by")
        val createdBy: Int = 0,
        @SerialName("updated_on")
        val updatedOn: Int? = null,
        @SerialName("is_completed")
        val isCompleted: Boolean = false,
        @SerialName("completed_on")
        val completedOn: Long? = null,
        @SerialName("passed_count")
        val passedCount: Int = 0,
        @SerialName("blocked_count")
        val blockedCount: Int = 0,
        @SerialName("untested_count")
        val untestedCount: Int = 0,
        @SerialName("retest_count")
        val retestCount: Int = 0,
        @SerialName("failed_count")
        val failedCount: Int = 0,
        @SerialName("custom_status1_count")
        val customStatus1Count: Int = 0,
        @SerialName("custom_status2_count")
        val customStatus2Count: Int = 0,
        @SerialName("custom_status3_count")
        val customStatus3Count: Int = 0,
        @SerialName("custom_status4_count")
        val customStatus4Count: Int = 0,
        @SerialName("custom_status5_count")
        val customStatus5Count: Int = 0,
        @SerialName("custom_status6_count")
        val customStatus6Count: Int = 0,
        @SerialName("custom_status7_count")
        val customStatus7Count: Int = 0,
        val entries: List<EntryModel>? = null) : TestRailModel

@Serializable
data class EntryModel(
        val id: String? = null,
        val name: String? = null,
        @SerialName("suite_id")
        val suiteId: Int? = null,
        @SerialName("assignedto_id")
        val assignedToId: Int? = null,
        @SerialName("include_all")
        val includeAll: Boolean? = null,
        @SerialName("case_ids")
        val caseIds: List<Int>? = null,
        @SerialName("config_ids")
        val configIds: List<Int>? = null,
        val runs: List<RunModel>? = null) : TestRailModel

@Serializable
data class RunModel(
        val id: Int = 0,
        val name: String? = null,
        val description: String? = null,
        val url: String? = null,
        @SerialName("project_id")
        val projectId: Int = 0,
        @SerialName("plan_id")
        val planId: Int? = null,
        @SerialName("suite_id")
        val suiteId: Int? = null,
        @SerialName("milestone_id")
        val milestoneId: Int? = null,
        @SerialName("assignedto_id")
        val assignedToId: Int? = null,
        @SerialName("include_all")
        val includeAll: Boolean? = null,
        @SerialName("case_ids")
        val caseIds: List<Int>? = null,
        @SerialName("created_on")
        val createdOn: Long? = null,
        @SerialName("created_by")
        val createdBy: Int = 0,
        @SerialName("updated_on")
        val updatedOn: Int? = null,
        @SerialName("is_completed")
        val isCompleted: Boolean = false,
        @SerialName("completed_on")
        val completedOn: Long? = null,
        val config: List<String>? = null,
        @SerialName("config_ids")
        val configIds: List<Int>? = null,
        @SerialName("passed_count")
        val passedCount: Int = 0,
        @SerialName("blocked_count")
        val blockedCount: Int = 0,
        @SerialName("untested_count")
        val untestedCount: Int = 0,
        @SerialName("retest_count")
        val retestCount: Int = 0,
        @SerialName("failed_count")
        val failedCount: Int = 0,
        @SerialName("custom_status1_count")
        val customStatus1Count: Int = 0,
        @SerialName("custom_status2_count")
        val customStatus2Count: Int = 0,
        @SerialName("custom_status3_count")
        val customStatus3Count: Int = 0,
        @SerialName("custom_status4_count")
        val customStatus4Count: Int = 0,
        @SerialName("custom_status5_count")
        val customStatus5Count: Int = 0,
        @SerialName("custom_status6_count")
        val customStatus6Count: Int = 0,
        @SerialName("custom_status7_count")
        val customStatus7Count: Int = 0,
        @SerialName("entry_id")
        val entryId: String? = null,
        @SerialName("entry_index")
        val entryIndex: Int = 0,
        val refs: String? = null,) : TestRailModel