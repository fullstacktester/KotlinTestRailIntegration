package com.github.fullstacktester.testrail.models
import com.github.fullstacktester.testrail.models.CaseModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class CaseTest {

    private val json = """
            {
                "created_by": 5,
                "created_on": 1392300984,
                "estimate": "1m 5s",
                "estimate_forecast": null,
                "id": 1,
                "milestone_id": 7,
                "priority_id": 2,
                "refs": "RF-1, RF-2",
                "section_id": 1,
                "suite_id": 1,
                "title": "Change document attributes (author, title, organization)",
                "type_id": 4,
                "updated_by": 1,
                "updated_on": 1393586511
            }
        """

    private val case = CaseModel(
        createdBy = 5,
        createdOn = 1392300984,
        estimate = "1m 5s",
        estimateForecast = null,
        id = 1,
        milestoneId = 7,
        priorityId = 2,
        refs = "RF-1, RF-2",
        sectionId = 1,
        suiteId = 1,
        title = "Change document attributes (author, title, organization)",
        typeId = 4,
        updatedBy = 1,
        updatedOn = 1393586511
    )

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<CaseModel>(json)

        actualCase.shouldBe(case)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json{encodeDefaults = true}.encodeToString(case)

        actualJson.shouldMatchJson(json)
    }
}

