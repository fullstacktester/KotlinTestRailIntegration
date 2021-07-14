package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import com.github.fullstacktester.testrail.TestRailHttp
import com.github.fullstacktester.testrail.models.PriorityModel
import com.github.fullstacktester.testrail.TestRailRequest

class Priorities {

    fun getPriorities(): List<PriorityModel> {
        val request = TestRailRequest("GET", "get_priorities/")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}