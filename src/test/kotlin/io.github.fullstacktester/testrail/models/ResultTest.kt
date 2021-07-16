package io.github.fullstacktester.testrail.models

import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import io.github.fullstacktester.testrail.models.serializers.ResultFieldSerializer

class ResultTest {

    private var json = """
        {
            "assignedto_id": 1,
            "comment": "This test failed: ..",
            "created_by": 1,
            "created_on": 1393851801,
            "defects": "TR-1",
            "elapsed": "5m",
            "id": 1,
            "status_id": 5,
            "test_id": 1,
            "version": "1.0RC1"
	    }
    """

    val customStepResult = """
            , 
            "custom_step_results": 
            [
                {
                    "content": "Step 1",
                    "expected": "Expected Result 1",
                    "actual": "Actual Result 1",
                    "status_id": 1
                },
                {
                    "content": "Step 2",
                    "expected": "Expected Result 2",
                    "actual": "Actual Result 2",
                    "status_id": 2
                }
            ]
        }
    """

    private var result = ResultModel(
            assignedToId = 1,
            comment = "This test failed: ..",
            createdBy = 1,
            createdOn = 1393851801,
            defects = "TR-1",
            elapsed = "5m",
            id = 1,
            statusId = 5,
            testId = 1,
            version = "1.0RC1"

    )

    private var stepResults = StepResultsCustomField(
            type = "StepResultsCustom",
            name = "custom_step_results",
            value = listOf(
                        StepResult(
                                content = "Step 1",
                                expected = "Expected Result 1",
                                actual = "Actual Result 1",
                                statusId = 1
                        ),
                        StepResult(
                                content = "Step 2",
                                expected = "Expected Result 2",
                                actual = "Actual Result 2",
                                statusId = 2
                        )
            ))

    @Test
    fun `Can serialize a Result with no custom fields to JSON`() {
        val actualTestJson = Json.encodeToString(ResultFieldSerializer, result)

        actualTestJson.shouldMatchJson(json)
    }

    @Test
    fun `Can deserialize a Result with no custom fields from JSON`() {
        val actualTest = Json.decodeFromString(ResultFieldSerializer, json)

        actualTest.shouldBe(result)
    }

    @Test
    fun `Can serialize a Result with a Step Result field to JSON`() {
        val customJson = json.replace("}", customStepResult)
        result.customFields = listOf(stepResults)

        val actualTestJson = Json.encodeToString(ResultFieldSerializer, result)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a Result with Step Result field from JSON`() {
        val customJson = json.replace("}", customStepResult)
        result.customFields = listOf(stepResults)

        val actualTest = Json.decodeFromString(ResultFieldSerializer, customJson)

        actualTest.shouldBe(result)
    }

    @Test
    fun `Can serialize a list of Results to JSON`() {
        val customJson = json.replace("{","[{").replace("}", "}]")
        val results = listOf(result)

        val actualTestJson = Json.encodeToString(ListSerializer(ResultFieldSerializer), results)

        actualTestJson.shouldMatchJson(customJson)
    }

    @Test
    fun `Can deserialize a list of Result from JSON`() {
        val customJson = json.replace("{","[{").replace("}", "}]")
        val results = listOf(result)

        val actualTest = Json.decodeFromString(ListSerializer(ResultFieldSerializer), customJson)

        actualTest.shouldBe(results)
    }

}