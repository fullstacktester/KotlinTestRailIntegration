package io.github.fullstacktester.testrail.models

import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import io.github.fullstacktester.testrail.models.serializers.TestFieldSerializer

class TestTest {

    var json = """
        {
            "assignedto_id": 1,
            "case_id": 1,
            "estimate": "1m5s",
            "id": 100,
            "priority_id": 2,
            "run_id": 1,
            "status_id": 5,
            "title": "Verifylinespacingonmulti-pagedocument",
            "type_id": 4
        }        
    """

    var test = TestModel(
            assignedToId = 1,
            caseId = 1,
            estimate = "1m5s",
            id = 100,
            priorityId = 2,
            runId = 1,
            statusId = 5,
            title = "Verifylinespacingonmulti-pagedocument",
            typeId = 4 )


    // No custom fields

    @Test
    fun `Can serialize a Test with no custom fields to JSON`() {
        val actualTestJson = Json.encodeToString(TestFieldSerializer, test)

        actualTestJson.shouldMatchJson(json)
    }

    @Test
    fun `Can deserialize a Test with no custom fields from JSON`() {
        val actualTest = Json.decodeFromString(TestFieldSerializer, json)

        actualTest.shouldBe(test)
    }

    // String custom field

    @Test
    fun `Can serialize a Test with a String custom field to JSON`() {
        val customJson = json.replace("}", """, "custom_field":"This is a custom String field" }""")
        test.customFields = listOf(StringCustomField(type = "StringCustom", name = "custom_field", value = "This is a custom String field"))

        val actualTestJson = Json.encodeToString(TestFieldSerializer, test)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a Test with a String custom field from JSON`() {
        val customJson = json.replace("}", """, "custom_field":"This is a custom String field" }""")
        test.customFields = listOf(StringCustomField(type = "StringCustom", name = "custom_field", value = "This is a custom String field"))

        val actualTest = Json.decodeFromString(TestFieldSerializer, customJson)

        actualTest.shouldBe(test)
    }

    // Integer custom field

    @Test
    fun `Can serialize a Test with an Integer custom field to JSON`() {
        val customJson = json.replace("}", """, "custom_field": 123 }""")
        test.customFields = listOf(IntCustomField(type = "IntCustom", name = "custom_field", value = 123))

        val actualTestJson = Json.encodeToString(TestFieldSerializer, test)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a Test with an Integer custom field from JSON`() {
        val customJson = json.replace("}", """, "custom_field": 123 }""")
        test.customFields = listOf(IntCustomField(type = "IntCustom", name = "custom_field", value = 123))

        val actualTest = Json.decodeFromString(TestFieldSerializer, customJson)

        actualTest.shouldBe(test)
    }


    // Boolean custom field

    @Test
    fun `Can serialize a Test with a Boolean custom field to JSON`() {
        val customJson = json.replace("}", """, "custom_field": true }""")
        test.customFields = listOf(BooleanCustomField(type = "BooleanCustom", name = "custom_field", value = true))

        val actualTestJson = Json.encodeToString(TestFieldSerializer, test)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a Test with a Boolean custom field from JSON`() {
        val customJson = json.replace("}", """, "custom_field": true }""")
        test.customFields = listOf(BooleanCustomField(type = "BooleanCustom", name = "custom_field", value = true))

        val actualTest = Json.decodeFromString(TestFieldSerializer, customJson)

        actualTest.shouldBe(test)
    }

    // Int list custom field

    @Test
    fun `Can serialize a Test with an Int List custom field to JSON`() {
        val customJson = json.replace("}", """, "custom_field": [1, 2, 3] }""")
        test.customFields = listOf(IntsCustomField(type = "IntsCustom", name = "custom_field", value = listOf(1, 2, 3)))

        val actualTestJson = Json.encodeToString(TestFieldSerializer, test)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a Test with an Int List custom field from JSON`() {
        val customJson = json.replace("}", """, "custom_field": [1, 2, 3] }""")
        test.customFields = listOf(IntsCustomField(type = "IntsCustom", name = "custom_field", value = listOf(1, 2, 3)))

        val actualTest = Json.decodeFromString(TestFieldSerializer, customJson)

        actualTest.shouldBe(test)
    }

    // Steps custom field

    @Test
    fun `Can serialize a Test with a Steps custom field to JSON`() {
        val customJson = json.replace("}", """, "custom_field": [{"content": "Step 1", "expected": "Expected Result 1"}, {"content": "Step 2", "expected": "Expected Result 2"} ] }""")
        test.customFields = listOf(
            StepsCustomField(type = "StepsCustom", name = "custom_field",
                value = listOf(
                    Step("Step 1", "Expected Result 1"),
                    Step("Step 2", "Expected Result 2")
                ))
        )

        val actualTestJson = Json.encodeToString(TestFieldSerializer, test)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a Test with a Steps custom field from JSON`() {
        val customJson = json.replace("}", """, "custom_field": [{"content": "Step 1", "expected": "Expected Result 1"}, {"content": "Step 2", "expected": "Expected Result 2"} ] }""")
        test.customFields = listOf(
            StepsCustomField(type = "StepsCustom", name = "custom_field",
                value = listOf(
                    Step("Step 1", "Expected Result 1"),
                    Step("Step 2", "Expected Result 2")
                ))
        )

        val actualTest = Json.decodeFromString(TestFieldSerializer, customJson)

        actualTest.shouldBe(test)
    }

}

