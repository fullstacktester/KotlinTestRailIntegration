package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class ConfigsModel(
        val id: Int = 0,
        val name: String? = null,
        @SerialName("project_id")
        val projectId: Int = 0,
        val configs: List<ConfigModel>? = null) : TestRailModel

@Serializable
data class ConfigModel(
        val id: Int = 0,
        val name: String? = null,
        @SerialName("group_id")
        val groupId: Int = 0)
