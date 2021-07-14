package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class StatusModel(
        val id: Int,
        val name: String,
        val label: String,
        @SerialName("color_dark")
        val colorDark: Int,
        @SerialName("color_medium")
        val colorMedium: Int,
        @SerialName("color_bright")
        val colorBright: Int,
        @SerialName("is_system")
        val isSystem: Boolean,
        @SerialName("is_untested")
        val isUntested: Boolean,
        @SerialName("is_final")
        val isFinal: Boolean) : TestRailModel