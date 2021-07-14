package com.github.fullstacktester.testrail.models

import com.github.fullstacktester.testrail.models.CaseTypeModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class CaseTypeTest {

    private var json =
            """
                {
                    "id": 1,
                    "is_default": false,
                    "name": "Automated"
	            }        
            """

    private var caseType = CaseTypeModel(
        id = 1,
        name = "Automated",
        isDefault = false
    )

    @Test
    fun `Can serialize to JSON`() {
        val actualCaseType = Json.decodeFromString<CaseTypeModel>(json)

        actualCaseType.shouldBe(caseType)
    }

    @Test
    fun `Can deserialize from JSON`() {
        val actualJson = Json{encodeDefaults = true}.encodeToString(caseType)

        actualJson.shouldMatchJson(json)
    }
}