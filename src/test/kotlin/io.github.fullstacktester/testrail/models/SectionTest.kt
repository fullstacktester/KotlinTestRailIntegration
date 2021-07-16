package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.SectionModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class SectionTest {

    private val json = """
            {
                "depth": 0,
                "description": null,
                "display_order": 1,
                "id": 1,
                "name": "Prerequisites",
                "parent_id": null,
                "suite_id": 1
            }
        """

    private val section = SectionModel(
            depth = 0,
            description = null,
            displayOrder = 1,
            id = 1,
            name = "Prerequisites",
            parentId = null,
            suiteId = 1)

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<SectionModel>(json)

        actualCase.shouldBe(section)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json{encodeDefaults = true}.encodeToString(section)

        actualJson.shouldMatchJson(json)
    }
}