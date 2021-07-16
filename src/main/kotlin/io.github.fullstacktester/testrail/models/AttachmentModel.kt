package io.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import io.github.fullstacktester.testrail.TestRailModel

@Serializable
data class AttachmentModel(
        @SerialName("attachment_id")
        val attachmentId: Int ) : TestRailModel