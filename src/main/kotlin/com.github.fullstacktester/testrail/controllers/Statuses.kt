package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import com.github.fullstacktester.testrail.TestRailHttp
import com.github.fullstacktester.testrail.models.StatusModel
import com.github.fullstacktester.testrail.TestRailRequest

class Statuses {

    fun getStatuses(): List<StatusModel>{
        val request = TestRailRequest("POST", "get_statuses/")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}