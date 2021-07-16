package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.FieldModel
import io.github.fullstacktester.testrail.TestRailRequest

class ResultFields {

    fun getResultFields(): List<FieldModel> {
        val request = TestRailRequest("GET", "get_result_fields/")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}