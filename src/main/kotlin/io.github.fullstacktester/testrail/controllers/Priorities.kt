package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.PriorityModel
import io.github.fullstacktester.testrail.TestRailRequest

class Priorities {

    fun getPriorities(): List<PriorityModel> {
        val request = TestRailRequest("GET", "get_priorities/")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}