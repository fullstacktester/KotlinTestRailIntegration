package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class CaseModel(
        val id: Int = 0,
        val title: String? = null,
        @SerialName("section_id")
        val sectionId: Int = 0,
        @SerialName("type_id")
        val typeId: Int? = null,
        @SerialName("priority_id")
        val priorityId: Int? = null,
        @SerialName("milestone_id")
        val milestoneId: Int? = null,
        val refs: String? = null,
        @SerialName("created_by")
        val createdBy: Int = 0,
        @SerialName("created_on")
        val createdOn: Long? = null,
        @SerialName("updated_by")
        val updatedBy: Int = 0,
        @SerialName("updated_on")
        val updatedOn: Long? = null,
        val estimate: String? = null,
        @SerialName("estimate_forecast")
        val estimateForecast: String? = null,
        @SerialName("suite_id")
        val suiteId: Int = 0,) : TestRailModel