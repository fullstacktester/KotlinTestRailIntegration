package com.github.fullstacktester.testrail.models

import com.github.fullstacktester.testrail.models.ResultModel
import com.github.fullstacktester.testrail.models.ResultsModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class ResultsTest {

    private var json = """
        {
            "results": [
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
            version = "1.0RC1")

    private val results = ResultsModel(
            results = mutableListOf(result))

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<ResultsModel>(json)

        actualCase.shouldBe(results)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(results)

        actualJson.shouldMatchJson(json)
    }
}