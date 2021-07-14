package com.github.fullstacktester.testrail.controllers

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.platform.commons.util.Preconditions
import com.github.fullstacktester.testrail.TestRailHttp.Companion.execute
import com.github.fullstacktester.testrail.models.ProjectModel
import com.github.fullstacktester.testrail.TestRailRequest

class Projects {

    fun getProject(projectId: Int): ProjectModel {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("GET", "get_project/${projectId}")
        return Json.decodeFromString(execute(request))
    }

    fun getProjects(): List<ProjectModel> {
        val request = TestRailRequest("GET", "get_projects/")
        return Json.decodeFromString(execute(request))
    }

    fun addProject(project: ProjectModel): ProjectModel {
        val request = TestRailRequest("GET", "add_project/", Json.encodeToString(project))

        return Json.decodeFromString(execute(request))
    }

    fun updateProject(project: ProjectModel): ProjectModel {
        val request = TestRailRequest("POST", "update_project/${project.id}", Json.encodeToString(project))

        return Json.decodeFromString(execute(request))
    }

    fun deleteProject(projectId: Int) {
        Preconditions.condition(projectId > 0, "projectId should be positive")
        val request = TestRailRequest("POST", "delete_project/${projectId}")

        return Json.decodeFromString(execute(request))
    }
}