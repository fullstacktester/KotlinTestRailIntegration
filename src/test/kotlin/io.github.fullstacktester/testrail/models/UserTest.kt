package io.github.fullstacktester.testrail.models

import io.github.fullstacktester.testrail.models.UserModel
import io.kotest.assertions.json.shouldMatchJson
import io.kotest.matchers.shouldBe
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class UserTest {

    private val json = """
            {
                "id" : 1,
                "email" : "test@example.com",
                "name" : "User name",
                "role" : "User role",
                "role_id" : 1,
                "is_active" : true
            }
        """

    private val user = UserModel(
            id = 1,
            email = "test@example.com",
            name = "User name",
            role = "User role",
            roleId = 1,
            isActive = true)

    @Test
    fun `Can deserialize from JSON`() {
        val actualCase = Json.decodeFromString<UserModel>(json)

        actualCase.shouldBe(user)
    }

    @Test
    fun `Can serialize to JSON`() {
        val actualJson = Json.encodeToString(user)

        actualJson.shouldMatchJson(json)
    }
}