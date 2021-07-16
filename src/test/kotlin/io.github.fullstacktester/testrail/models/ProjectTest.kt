package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.ProjectModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class ProjectTest {

    private val json = """
            {
                "announcement": "..",
                "completed_on": 1609779466,
                "id": 1,
                "is_completed": true,
                "name": "Datahub",
                "show_announcement": true,
                "url": "http:///testrail/index.php?/projects/overview/1",
                "suite_mode" : 1
            }
        """

    private val project = ProjectModel(
            id = 1,
            name = "Datahub",
            announcement = "..",
            showAnnouncement = true,
            isCompleted = true,
            completedOn = 1609779466,
            url = "http:///testrail/index.php?/projects/overview/1",
            suiteMode = 1)

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<ProjectModel>(json)

        actualCase.shouldBe(project)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(project)

        actualJson.shouldMatchJson(json)
    }
}