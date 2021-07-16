package io.github.fullstacktester.testrail

import kotlinx.serialization.Serializable

@Serializable
data class TestRailRequest(val method: String, val path: String, val jsonBody: String? = null)