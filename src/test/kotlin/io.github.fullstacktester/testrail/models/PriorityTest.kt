package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.PriorityModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class PriorityTest {

    private val json = """
            {
                "id" : 123,
                "name" : "Test Priority",
                "short_name" : "test",
                "priority" : 1,
                "is_default" : false
            }
        """

    private val priority = PriorityModel(
            id = 123,
            name = "Test Priority",
            shortName = "test",
            priority = 1,
            isDefault = false)

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<PriorityModel>(json)

        actualCase.shouldBe(priority)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(priority)

        actualJson.shouldMatchJson(json)
    }
}

