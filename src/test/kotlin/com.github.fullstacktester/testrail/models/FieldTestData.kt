package com.github.fullstacktester.testrail.models

class FieldTestData {

    companion object {
        var jsonStringField =
                """
                {
                    "id": 1,
                    "configs": [],
                    "description": "A field",
                    "display_order": 1,
                    "label": "Field",
                    "name": "Field",
                    "system_name": "custom_field",
                    "type_id": 1,
                    "is_active": true,
                    "include_all": false,
                    "template_ids": []
                }
            """

        private var jsonConfig =
                """
                    "configs" : [
                        {
                            "id" : "4be1345cafd07",
                            "context" : {
                                "is_global" : true,
                                "project_ids" : []
                            },
                            "options" : {}
                        }
                    ]
                """
        private fun jsonTextConfig() :String {
            val options =
                """
                    "options" : {
                        "is_required" : false,
                        "default_value" : "",
                        "format" : "plain",
                        "rows" : "3"
                    }
                    """

            return jsonConfig.replace(""""options" : {}""", options)
        }

        private fun jsonDropdownConfig() :String {
            val options =
                    """
                   "options" : {
                        "is_required" : false,
                        "default_value" : "",
                        "items" : "0, zero\n1, One"
                    }
                    """

            return jsonConfig.replace(""""options" : {}""", options)
        }

        private fun jsonStepsConfig() :String {
            val options =
                    """
                   "options" : {
                        "is_required" : false,
                        "format" : "plain",
                        "rows" : "3",
                        "has_expected" : false
                    }
                    """

            return jsonConfig.replace(""""options" : {}""", options)
        }

        private fun jsonStepResultsConfig() :String {
            val options =
                    """
                    "options" : {
                        "is_required" : false,
                        "format" : "plain",
                        "rows" : "3",
                        "has_expected" : false,
                        "has_actual" : false
                    }
                    """

            return jsonConfig.replace(""""options" : {}""", options)
        }

        private fun jsonMultiSelectConfig() :String {
            val options =
                    """
                    "options" : {
                        "is_required" : false,
                        "items" : "0, zero\n1, One"
                    }
                    """

            return jsonConfig.replace(""""options" : {}""", options)
        }

        var jsonIntegerField= jsonStringField
                .replace(""""type_id": 1""", """"type_id": 2""")

        var jsonTextField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 3""")
                .replace(""""configs": []""",
                    jsonTextConfig()
                )

        var jsonUrlField =
                jsonStringField.replace(""""type_id": 1""", """"type_id": 4""")

        var jsonCheckboxField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 5""")

        var jsonDropdownField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 6""")
                .replace(""""configs": []""",
                    jsonDropdownConfig()
                )

        var jsonUserField =
                jsonStringField.replace(""""type_id": 1""", """"type_id": 7""")

        var jsonDateField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 8""")

        var jsonMilestoneField=
                jsonStringField.replace(""""type_id": 1""", """"type_id": 9""")

        var jsonStepsField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 10""")
                .replace(""""configs": []""",
                    jsonStepsConfig()
                )

        var jsonStepResultsField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 11""")
                .replace(""""configs": []""",
                    jsonStepResultsConfig()
                )

        var jsonMultiSelectField = jsonStringField
                .replace(""""type_id": 1""", """"type_id": 12""")
                .replace(""""configs": []""",
                    jsonMultiSelectConfig()
                )

        var stringField = StringField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 1,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var integerField = IntegerField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 2,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var textField = TextField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 3,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = listOf(
                TextFieldConfig(
                    id = "4be1345cafd07",
                    options = TextOptions(
                        isRequired = false,
                        defaultValue = "",
                        format = Format.plain,
                        rows = "3"
                    ),
                    context = Context(
                        isGlobal = true,
                        projectIds = emptyList()
                    )
                )
            )
        )

        var urlField = UrlField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 4,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var checkboxField = CheckboxField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 5,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var dropdownField = DropdownField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 6,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = listOf(
                DropdownFieldConfig(
                    id = "4be1345cafd07",
                    options = DropdownOptions(
                        isRequired = false,
                        defaultValue = "",
                        items = "0, zero\n1, One"
                    ),
                    context = Context(
                        isGlobal = true,
                        projectIds = emptyList()
                    )
                )
            )
        )

        var userField = UserField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 7,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var dateField = DateField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 8,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var milestoneField = MilestoneField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 9,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = emptyList()
        )

        var stepsField = StepsField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 10,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = listOf(
                StepsFieldConfig(
                    id = "4be1345cafd07",
                    options = StepsOptions(
                        isRequired = false,
                        format = Format.plain,
                        hasExpected = false,
                        rows = "3"
                    ),
                    context = Context(
                        isGlobal = true,
                        projectIds = emptyList()
                    )
                )
            )
        )

        var stepResultsField = StepResultsField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 11,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = listOf(
                StepResultsFieldConfig(
                    id = "4be1345cafd07",
                    options = StepResultsOptions(
                        isRequired = false,
                        format = Format.plain,
                        hasExpected = false,
                        hasActual = false,
                        rows = "3"
                    ),
                    context = Context(
                        isGlobal = true,
                        projectIds = emptyList()
                    )
                )
            )
        )

        val multiSelectField = MultiSelectField(
            id = 1,
            label = "Field",
            name = "Field",
            description = "A field",
            systemName = "custom_field",
            typeId = 12,
            displayOrder = 1,
            isActive = true,
            includeAll = false,
            templateIds = emptyList(),
            configs = listOf(
                MultiSelectFieldConfig(
                    id = "4be1345cafd07",
                    options = MultiSelectOptions(
                        isRequired = false,
                        items = "0, zero\n1, One"
                    ),
                    context = Context(
                        isGlobal = true,
                        projectIds = emptyList()
                    )
                )
            )
        )
    }

}