package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import com.github.fullstacktester.testrail.TestRailHttp
import com.github.fullstacktester.testrail.models.FieldModel
import com.github.fullstacktester.testrail.TestRailRequest

class ResultFields {

    fun getResultFields(): List<FieldModel> {
        val request = TestRailRequest("GET", "get_result_fields/")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}