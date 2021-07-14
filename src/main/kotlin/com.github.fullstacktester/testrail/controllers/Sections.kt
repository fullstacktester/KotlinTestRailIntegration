package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import com.github.fullstacktester.testrail.TestRailHttp
import com.github.fullstacktester.testrail.models.SectionModel
import com.github.fullstacktester.testrail.TestRailRequest

class Sections {

    fun getSection(sectionId: Int): SectionModel {
        Preconditions.condition(sectionId > 0, "sectionId should be positive")
        val request = TestRailRequest("GET", "get_section/${sectionId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getSections(projectId: Int): List<SectionModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_sections/${projectId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun getSectionsForSuite(projectId: Int, suiteId: Int): List<SectionModel> {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        Preconditions.condition(suiteId > 0, "suiteId should be positive")
        val request = TestRailRequest("GET", "get_sections/${projectId}&suite_id=${suiteId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun addSection(projectId: Int, section: SectionModel): SectionModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("POST", "add_section/", Json.encodeToString(section))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun updateSection(section: SectionModel): SectionModel {
        val request = TestRailRequest("POST", "update_section/${section.id}", Json.encodeToString(section))

        return Json.decodeFromString(TestRailHttp.execute(request))
    }

    fun deleteSection(sectionId: Int) {
        Preconditions.condition(sectionId > 0, "sectionId should be positive")
        val request = TestRailRequest("POST", "delete_section/${sectionId}")

        return Json.decodeFromString(TestRailHttp.execute(request))
    }
}