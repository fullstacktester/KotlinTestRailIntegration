package io.github.fullstacktester.testrail.models

class PlanTest {

    private val json = """
            {
                "assignedto_id": null,
                "blocked_count": 2,
                "completed_on": null,
                "created_by": 1,
                "created_on": 1393845644,
                "custom_status1_count": 0,
                "custom_status2_count": 0,
                "custom_status3_count": 0,
                "custom_status4_count": 0,
                "custom_status5_count": 0,
                "custom_status6_count": 0,
                "custom_status7_count": 0,
                "description": null,
                "entries": [
                {
                    "id": "3933d74b-4282-4c1f-be62-a641ab427063",
                    ""description": null,"
                    ""include_all": true,"
                    "name": "File Formats",
                    "runs": [
                    {
                        "assignedto_id": 6,
                        "blocked_count": 0,
                        "completed_on": null,
                        "config": "Firefox, Ubuntu 12",
                        "config_ids": [
                            2,
                            6
                        ],
                        "custom_status1_count": 0,
                        "custom_status2_count": 0,
                        "custom_status3_count": 0,
                        "custom_status4_count": 0,
                        "custom_status5_count": 0,
                        "custom_status6_count": 0,
                        "custom_status7_count": 0,
                        "description": null,
                        "entry_id": "3933d74b-4282-4c1f-be62-a641ab427063",
                        "entry_index": 1,
                        "failed_count": 2,
                        "id": 81,
                        "include_all": false,
                        "is_completed": false,
                        "milestone_id": 7,
                        "name": "File Formats",
                        "passed_count": 2,
                        "plan_id": 80,
                        "project_id": 1,
                        "retest_count": 1,
                        "refs": "RF-1, RF-2"
                        "suite_id": 4,
                        "untested_count": 3,
                        "url": "http:///testrail/index.php?/runs/view/81"
                    },
                    {
                        ..
                    }
                    ],
                    "refs": "RF-1, RF-2"
                    "suite_id": 4
                }
                ],
                "failed_count": 2,
                "id": 80,
                "is_completed": false,
                "milestone_id": 7,
                "name": "System test",
                "passed_count": 5,
                "project_id": 1,
                "retest_count": 1,
                "untested_count": 6,
                "url": "http:///testrail/index.php?/plans/view/80"
            }
        """

//    private val plan = Plan(
//            id = 12345,
//            name = "plan name",
//            description = "plan description",
//            projectId = 1,
//            url = "http://example.com",
//            milestoneId = 1234,
//            assignedToId = 1234,
//            createdOn = 1234,
//            createdBy = 1234,
//            isCompleted = true,
//            completedOn = 1234,
//            passedCount = 1234,
//            blockedCount = 1234,
//            untestedCount = 1234,
//            retestCount = 1234,
//            failedCount = 1234,
//            customStatus1Count = 1234,
//            customStatus2Count = 1234,
//            customStatus3Count = 1234,
//            customStatus4Count = 1234,
//            customStatus5Count = 1234,
//            customStatus6Count = 1234,
//            customStatus7Count = 1234,
//            entries = 1234,
//
//
//
//    )
//
//
//
//    @Test
//    fun `Can serialize to JSON`() {
//        val actualCase = Json.decodeFromString<Milestone>(json)
//
//        actualCase.shouldBe(milestone)
//    }
//
//    @Test
//    fun `Can deserialize from JSON`() {
//        val actualJson = Json{encodeDefaults = true}.encodeToString(milestone)
//
//        actualJson.shouldMatchJson(json)
//    }
}