package io.github.fullstacktester.testrail.models

import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.checkboxField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.dateField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.dropdownField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.integerField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonCheckboxField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonDateField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonDropdownField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonIntegerField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonMilestoneField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonMultiSelectField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonStepResultsField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonStepsField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonStringField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonTextField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonUrlField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.jsonUserField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.milestoneField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.multiSelectField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.stepResultsField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.stepsField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.stringField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.textField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.urlField
import io.github.fullstacktester.testrail.models.FieldTestData.Companion.userField

class FieldTest {

    @Test
    fun `Can serialize a String field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonStringField)

        actualField.shouldBe(stringField)
    }

    @Test
    fun `Can deserialize a String field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(stringField)

        actualJson.shouldMatchJson(jsonStringField)
    }

    @Test
    fun `Can serialize an Integer field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonIntegerField)

        actualField.shouldBe(integerField)
    }

    @Test
    fun `Can deserialize an Integer field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(integerField)

        actualJson.shouldMatchJson(jsonIntegerField)
    }

    @Test
    fun `Can serialize a Text field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonTextField)

        actualField.shouldBe(textField)
    }

    @Test
    fun `Can deserialize a Text field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(textField)

        actualJson.shouldMatchJson(jsonTextField)
    }

    @Test
    fun `Can serialize a Url field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonUrlField)

        actualField.shouldBe(urlField)
    }

    @Test
    fun `Can deserialize a Url field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(urlField)

        actualJson.shouldMatchJson(jsonUrlField)
    }

    @Test
    fun `Can serialize a Checkbox field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonCheckboxField)

        actualField.shouldBe(checkboxField)
    }

    @Test
    fun `Can deserialize a Checkbox field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(checkboxField)

        actualJson.shouldMatchJson(jsonCheckboxField)
    }

    @Test
    fun `Can serialize a Dropdown field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonDropdownField)

        actualField.shouldBe(dropdownField)
    }

    @Test
    fun `Can deserialize a Dropdown field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(dropdownField)

        actualJson.shouldMatchJson(jsonDropdownField)
    }

    @Test
    fun `Can serialize a User field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonUserField)

        actualField.shouldBe(userField)
    }

    @Test
    fun `Can deserialize a User field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(userField)

        actualJson.shouldMatchJson(jsonUserField)
    }

    @Test
    fun `Can serialize a Date field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonDateField)

        actualField.shouldBe(dateField)
    }

    @Test
    fun `Can deserialize a Date field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(dateField)

        actualJson.shouldMatchJson(jsonDateField)
    }

    @Test
    fun `Can serialize a Milestone field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonMilestoneField)

        actualField.shouldBe(milestoneField)
    }

    @Test
    fun `Can deserialize a Milestone field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(milestoneField)

        actualJson.shouldMatchJson(jsonMilestoneField)
    }

    @Test
    fun `Can serialize a Steps field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonStepsField)

        actualField.shouldBe(stepsField)
    }

    @Test
    fun `Can deserialize a Steps field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(stepsField)

        actualJson.shouldMatchJson(jsonStepsField)
    }

    @Test
    fun `Can serialize a StepResults field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonStepResultsField)

        actualField.shouldBe(stepResultsField)
    }

    @Test
    fun `Can deserialize a StepResults field from JSON`() {
        val actualJson = Json{ encodeDefaults = true; classDiscriminator = "type_id" }.encodeToString(stepResultsField)

        actualJson.shouldMatchJson(jsonStepResultsField)
    }

    @Test
    fun `Can serialize a MultiSelect field to JSON`() {
        val actualField = Json { encodeDefaults = true; classDiscriminator = "type_id" }.decodeFromString<FieldModel>(jsonMultiSelectField)

        actualField.shouldBe(multiSelectField)
    }

    @Test
    fun `Can deserialize a MultiSelect field from JSON`() {
        val actualJson = Json { encodeDefaults = true; classDiscriminator = "type_id"  }.encodeToString(multiSelectField)

        actualJson.shouldMatchJson(jsonMultiSelectField)
    }

}