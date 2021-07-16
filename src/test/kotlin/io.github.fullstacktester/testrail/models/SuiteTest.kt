package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.SuiteModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class SuiteTest {

    private val json = """
            {
                "description" : "..",
                "id" : 1,
                "name" : "Setup & Installation",
                "project_id" : 1,
                "url" : "http://testrail/index.php?/suites/view/1",
                "is_baseline" : false,
                "is_completed" : true,
                "completed_on" : 1609774382,
                "is_master" : true                               
            }
        """

    private val suite = SuiteModel(
            description = "..",
            id = 1,
            name = "Setup & Installation",
            projectId = 1,
            url = """http://testrail/index.php?/suites/view/1""",
            isBaseline = false,
            isCompleted = true,
            completedOn = 1609774382,
            isMaster = true)

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<SuiteModel>(json)

        actualCase.shouldBe(suite)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(suite)

        actualJson.shouldMatchJson(json)
    }
}