package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

//https://www.gurock.com/testrail/docs/api/reference/suites

@Serializable
data class SuiteModel(
        val id: Int? = null,
        val name: String,
        val description: String,
        @SerialName("project_id")
        val projectId: Int? = null,
        @SerialName("is_baseline")
        val isBaseline: Boolean? = null,
        @SerialName("is_completed")
        val isCompleted: Boolean? = null,
        @SerialName("completed_on")
        val completedOn: Long? = null,
        @SerialName("is_master")
        val isMaster: Boolean? = null,
        val url: String? = null) : TestRailModel