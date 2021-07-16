package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import io.github.fullstacktester.testrail.TestRailRequest
import io.github.fullstacktester.testrail.TestRailHttp.Companion.execute
import io.github.fullstacktester.testrail.models.FieldModel

class CaseFields {

    fun getCaseFields(): List<FieldModel> {
        val request = TestRailRequest("GET", "get_case_fields")

        return Json.decodeFromString(execute(request))
    }

    fun addCaseFields(field: FieldModel): FieldModel {
        val request = TestRailRequest("POST", "add_case_field", Json.encodeToString(field))

        return Json.decodeFromString(execute(request))
    }

}