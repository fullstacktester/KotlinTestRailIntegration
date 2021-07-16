package io.github.fullstacktester.testrail.models.serializers

import io.github.fullstacktester.testrail.models.*
import io.github.fullstacktester.testrail.models.json.*
import kotlinx.serialization.json.*

fun extractCustomFields(element: JsonElement): JsonElement {
    val elements = element.jsonObject
            .filterNot { (k, _) -> k.startsWith("custom")}
            .toMutableMap()

    val custom = element.jsonObject
            .filter { (k, _) -> k.startsWith("custom") }

    if (custom.isNotEmpty()) {
        val customWithTypes = custom.map { addType(it) }
        elements["custom_fields"] = JsonArray(customWithTypes)
    }

    return JsonObject(elements)
}

fun addBackCustomFields(element: JsonElement): JsonElement {
    val elements = element.jsonObject
            .filterNot { (k, _) -> k == "custom_fields" }
            .toMutableMap()

    val custom = element.jsonObject
            .filter { (k, _) -> k == "custom_fields" }
            .map { it.value }

    if(custom.isNotEmpty()) {
        custom[0].jsonArray.forEach { elements[it.jsonObject["name"]?.jsonPrimitive!!.content] = it.jsonObject["value"]!! }
    }

    return JsonObject(elements)
}

private fun addType(entry: Map.Entry<String, JsonElement>): JsonObject {

    fun newMapWithType(type: String): JsonObject {
        val mapWithType = mutableMapOf("type" to JsonPrimitive(type), "name" to JsonPrimitive(entry.key), "value" to entry.value)

        return JsonObject(mapWithType)
    }

    return when {
        entry.value == JsonNull -> newMapWithType("NullCustom")
        entry.value.isString -> newMapWithType("StringCustom")
        entry.value.isInteger -> newMapWithType( "IntCustom")
        entry.value.isBoolean -> newMapWithType("BooleanCustom")
        entry.value.isListOfInts -> newMapWithType("IntsCustom")
        entry.value.isListOfSteps -> newMapWithType("StepsCustom")
        entry.value.isStepResults -> newMapWithType("StepResultsCustom")
        else -> throw IllegalArgumentException("Unknown type for: $entry")
    }
}

object TestFieldSerializer : JsonTransformingSerializer<TestModel>(TestModel.serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement = extractCustomFields(element)

    override fun transformSerialize(element: JsonElement): JsonElement = addBackCustomFields(element)
}

object ResultFieldSerializer : JsonTransformingSerializer<ResultModel>(ResultModel.serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement = extractCustomFields(element)

    override fun transformSerialize(element: JsonElement): JsonElement = addBackCustomFields(element)
}

object CustomFieldSerializer : JsonContentPolymorphicSerializer<CustomFieldModel>(CustomFieldModel::class) {
    override fun selectDeserializer(element: JsonElement) = when ((element.jsonObject["type"] as JsonPrimitive).contentOrNull) {
        "StringCustom" -> StringCustomField.serializer()
        "IntCustom" -> IntCustomField.serializer()
        "BooleanCustom" -> BooleanCustomField.serializer()
        "IntsCustom" -> IntsCustomField.serializer()
        "StepsCustom" -> StepsCustomField.serializer()
        "StepResultsCustom" -> StepResultsCustomField.serializer()
        "NullCustom" -> StringCustomField.serializer()
        else -> throw IllegalArgumentException("Unknown type for: $element")
    }
}
    
