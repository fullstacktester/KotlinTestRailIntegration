package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TestModel(
        val id: Int = 0,
        @SerialName("case_id")
        val caseId: Int = 0,
        @SerialName("assignedto_id")
        val assignedToId: Int? = null,
        val title: String? = null,
        @SerialName("status_id")
        val statusId: Int = 0,
        @SerialName("type_id")
        val typeId: Int = 0,
        @SerialName("priority_id")
        val priorityId: Int = 0,
        @SerialName("milestone_id")
        val milestoneId: Int? = null,
        @SerialName("run_id")
        val runId: Int? = null,
        val refs: String? = null,
        val estimate: String? = null,
        @SerialName("estimate_forecast")
        val estimateForecast: String? = null,
        @SerialName("custom_fields")
        var customFields: List<CustomFieldModel>? = null)





