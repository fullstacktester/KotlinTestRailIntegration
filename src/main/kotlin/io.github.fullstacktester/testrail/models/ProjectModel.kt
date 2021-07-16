package io.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import io.github.fullstacktester.testrail.TestRailModel

@Serializable
data class ProjectModel (
        val id: Int,
        val name: String? = null,
        val announcement: String? = null,
        @SerialName("show_announcement")
        val showAnnouncement: Boolean? = null,
        @SerialName("is_completed")
        val isCompleted: Boolean? = null,
        @SerialName("completed_on")
        val completedOn: Long? = null,
        val url: String? = null,
        @SerialName("suite_mode")
        val suiteMode: Int? = null): TestRailModel
