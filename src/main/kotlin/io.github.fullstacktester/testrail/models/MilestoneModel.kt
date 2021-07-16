package io.github.fullstacktester.testrail.models

import kotlinx.serialization.Serializable
import io.github.fullstacktester.testrail.TestRailModel

@Serializable
data class MilestoneModel(
        val id: Int = 0,
        val name: String? = null,
        val description: String? = null,
        val projectId: Int = 0,
        val dueOn: Long? = null,
        val isCompleted: Boolean? = null) : TestRailModel