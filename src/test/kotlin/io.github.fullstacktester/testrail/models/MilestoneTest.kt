package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.MilestoneModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class MilestoneTest {

    private val json = """
            {
                "id": 12345,
                "name": "milestone name",
                "description": "milestone description",
                "projectId": 1,
                "dueOn": 123343456,
                "isCompleted": true
            }
        """

    private val milestone = MilestoneModel(
            id = 12345,
            name = "milestone name",
            description = "milestone description",
            projectId = 1,
            dueOn = 123343456,
            isCompleted = true)



    @Test
    fun `Can serialize to JSON`() {
        val actualCase = Json.decodeFromString<MilestoneModel>(json)

        actualCase.shouldBe(milestone)
    }

    @Test
    fun `Can deserialize from JSON`() {
        val actualJson = Json{encodeDefaults = true}.encodeToString(milestone)

        actualJson.shouldMatchJson(json)
    }
}