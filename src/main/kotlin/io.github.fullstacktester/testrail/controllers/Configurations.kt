package io.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import io.github.fullstacktester.testrail.TestRailHttp
import io.github.fullstacktester.testrail.models.ConfigsModel
import io.github.fullstacktester.testrail.TestRailRequest

class Configurations {

    fun getConfigurations(projectId: Int): ConfigsModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_configs/${projectId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}