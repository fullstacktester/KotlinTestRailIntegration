package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.AttachmentModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class AttachmentTest {

    private val json = """
            {
                "attachment_id" : 123
            }
        """

    private val attachment = AttachmentModel(
        attachmentId = 123
    )

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<AttachmentModel>(json)

        actualCase.shouldBe(attachment)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(attachment)

        actualJson.shouldMatchJson(json)
    }
}