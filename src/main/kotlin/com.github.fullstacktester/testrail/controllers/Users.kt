package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import com.github.fullstacktester.testrail.TestRailHttp
import com.github.fullstacktester.testrail.models.UserModel
import com.github.fullstacktester.testrail.TestRailRequest

class Users {

    fun getUser(userId: Int): UserModel {
        Preconditions.condition(userId > 0, "userId should be positive")
        val request = TestRailRequest("GET", "get_user/${userId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getUserByEmail(email: String): UserModel {
        Preconditions.condition(email.isNotEmpty(), "email cannot be empty")
        val request = TestRailRequest("GET", "get_user_by_email&email=${email.trim { it <= ' ' }}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getUsers(): List<UserModel> {
        val request = TestRailRequest("GET", "get_users")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}