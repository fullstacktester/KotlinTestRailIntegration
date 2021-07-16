package io.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import io.github.fullstacktester.testrail.TestRailModel

@Serializable
data class PriorityModel(
        var id: Int = 0,
        val name: String? = null,
        @SerialName("short_name")
        val shortName: String? = null,
        val priority: Int = 0,
        @SerialName("is_default")
        val isDefault: Boolean) : TestRailModel