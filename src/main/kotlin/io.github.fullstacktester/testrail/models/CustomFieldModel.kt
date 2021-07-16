package io.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import io.github.fullstacktester.testrail.models.serializers.CustomFieldSerializer


@Serializable(with = CustomFieldSerializer::class)
abstract class CustomFieldModel

@Serializable
data class StringCustomField(val type: String, val name: String, val value: String?) : CustomFieldModel()

@Serializable
data class IntCustomField(val type: String, val name: String, val value: Int) : CustomFieldModel()

@Serializable
data class BooleanCustomField(val type: String, val name: String, val value: Boolean) : CustomFieldModel()

@Serializable
data class IntsCustomField(val type: String, val name: String, val value : List<Int>) : CustomFieldModel()

@Serializable
data class StepsCustomField(val type: String, val name: String, val value: List<Step>) : CustomFieldModel()

@Serializable
data class StepResultsCustomField(val type: String, val name: String, val value: List<StepResult>?) : CustomFieldModel()

@Serializable
data class Step(
        val content: String,
        val expected: String)

@Serializable
data class StepResult(
        val content: String,
        val expected: String,
        val actual: String,
        @SerialName("status_id")
        val statusId: Int)