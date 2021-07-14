package com.github.fullstacktester.testrail

import com.github.fullstacktester.testrail.models.RunModel
import com.github.fullstacktester.testrail.models.ResultModel
import com.github.fullstacktester.testrail.models.ResultsModel
import com.github.fullstacktester.testrail.controllers.Runs
import com.github.fullstacktester.testrail.controllers.Results


object TestRailReport {
    private val results = mutableListOf<ResultModel>()

    fun addResult(result: ResultModel) {
        results.add(result)
    }

    fun reportResults() {
        val config = TestRailConfig().config

        val projectId = config.projectId
        val suiteId = config.suiteId
        val runTitle = config.runTitle ?: "Kotlin Test report"
        val runDescription = config.runDescription ?: ""

        val run = Runs().addRun(
                projectId,
                RunModel(
                    projectId = projectId,
                    name = runTitle,
                    description = runDescription,
                    caseIds = results.map { r -> r.caseId!! },
                    suiteId = suiteId,
                    includeAll = false
                )
        )

        if (results.isNotEmpty()) {
            Results().addResultsForCases(run.id, ResultsModel(results))
        }

        Runs().closeRun(run.id)
    }
}