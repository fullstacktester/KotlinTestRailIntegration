package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class SectionModel(
        val id: Int = 0,
        val name: String? = null,
        val description: String? = null,
        @SerialName("suite_id")
        val suiteId: Int? = null,
        @SerialName("parent_id")
        val parentId: Int? = null,
        val depth: Int = 0,
        @SerialName("display_order")
        val displayOrder: Int = 0) : TestRailModel