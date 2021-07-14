package com.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.github.fullstacktester.testrail.TestRailModel

@Serializable
data class ResultModel (
    val id: Int? = 0,
    @SerialName("test_id")
        val testId: Int? = 0,
    @SerialName("case_id")
        val caseId: Int? = null,
    @SerialName("status_id")
        val statusId: Int? = null,
    @SerialName("created_on")
        val createdOn: Long? = null,
    @SerialName("created_by")
        val createdBy: Int? = 0,
    @SerialName("assignedto_id")
        val assignedToId: Int? = null,
    val comment: String? = null,
    val version: String? = null,
    val elapsed: String? = null,
    val defects: String? = null,
    @SerialName("attachment_ids")
        val attachmentIds: List<AttachmentModel>? = null,
    @SerialName("custom_fields")
        var customFields: List<CustomFieldModel>? = null) : TestRailModel

@Serializable
data class ResultsModel (
        val results: MutableList<ResultModel> = mutableListOf()) : TestRailModel
