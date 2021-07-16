package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.StatusModel
import io.github.fullstacktester.testrail.TestRailRequest

class Statuses {

    fun getStatuses(): List<StatusModel>{
        val request = TestRailRequest("POST", "get_statuses/")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}