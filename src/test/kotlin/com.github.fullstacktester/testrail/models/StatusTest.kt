package com.github.fullstacktester.testrail.models

import com.github.fullstacktester.testrail.models.StatusModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class StatusTest {

    private val json = """
            {
                "color_bright": 12709313,
                "color_dark": 6667107,
                "color_medium": 9820525,
                "id": 1,
                "is_final": true,
                "is_system": true,
                "is_untested": false,
                "label": "Passed",
                "name": "passed"
            }
        """

    private val status = StatusModel(
            colorBright = 12709313,
            colorDark = 6667107,
            colorMedium = 9820525,
            id = 1,
            isFinal = true,
            isSystem = true,
            isUntested = false,
            label = "Passed",
            name = "passed")

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<StatusModel>(json)

        actualCase.shouldBe(status)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(status)

        actualJson.shouldMatchJson(json)
    }
}