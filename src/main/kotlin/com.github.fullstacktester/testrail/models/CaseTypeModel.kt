package com.github.fullstacktester.testrail.models;

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class CaseTypeModel (
        val id: Int = 0,
        val name: String? = null,
        @SerialName("is_default")
        val isDefault: Boolean = false) : TestRailModel