package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class UserModel(
        val id: Int,
        val email: String,
        val name: String,
        val role: String? = null,
        @SerialName("role_id")
        val roleId: Int? = null,
        @SerialName("is_active")
        val isActive: Boolean? = null) : TestRailModel