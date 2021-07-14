package com.github.fullstacktester.testrail.models

import com.github.fullstacktester.testrail.models.ConfigModel
import com.github.fullstacktester.testrail.models.ConfigsModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class ConfigurationTest {

    private val json =
            """
                {
                    "configs": [
                        {
                            "group_id": 1,
                            "id": 1,
                            "name": "Chrome"
                        },
                        {
                            "group_id": 1,
                            "id": 2,
                            "name": "Firefox"
                        }
                    ],
                    "id": 1,
                    "name": "Browsers",
                    "project_id": 1
                }                            
            """

    private val configuration = ConfigsModel(
        id = 1,
        projectId = 1,
        name = "Browsers",
        configs = listOf(
            ConfigModel(
                id = 1,
                groupId = 1,
                name = "Chrome"
            ),
            ConfigModel(
                id = 2,
                groupId = 1,
                name = "Firefox"
            )
        )
    )

    @Test
    fun `Can serialize to JSON`() {
        val actualConfiguration = Json.decodeFromString<ConfigsModel>(json)

        actualConfiguration.shouldBe(configuration)
    }

    @Test
    fun `Can deserialize from JSON`() {
        val actualJson = Json{encodeDefaults = true}.encodeToString(configuration)

        actualJson.shouldMatchJson(json)
    }
}