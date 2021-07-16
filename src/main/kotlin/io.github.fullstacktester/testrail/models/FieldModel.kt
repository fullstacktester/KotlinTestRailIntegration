package io.github.fullstacktester.testrail.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class FieldModel {
        abstract val id: Int
        abstract val label: String?
        abstract val name: String?
        abstract val description: String?
        abstract val systemName: String?
        abstract val typeId: Int
        abstract val displayOrder: Int
        abstract val isActive: Boolean?
        abstract val includeAll: Boolean?
        abstract val templateIds: List<Int>?
        abstract val configs: List<FieldConfig>
}

@Serializable
@SerialName("1")
data class StringField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("2")
data class IntegerField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("3")
data class TextField(
    override val configs: List<TextFieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("4")
data class UrlField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("5")
data class CheckboxField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("6")
data class DropdownField(
    override val configs: List<DropdownFieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("7")
data class UserField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("8")
data class DateField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("9")
data class MilestoneField(
    override val configs: List<FieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("10")
data class StepsField(
    override val configs: List<StepsFieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("11")
data class StepResultsField(
    override val configs: List<StepResultsFieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
@SerialName("12")
data class MultiSelectField(
    override val configs: List<MultiSelectFieldConfig>,
    override val id: Int = 0,
    override val label: String? = null,
    override val name: String? = null,
    override val description: String? = null,
    @SerialName("system_name")
        override val systemName: String? = null,
    @SerialName("type_id")
        override val typeId: Int = 0,
    @SerialName("display_order")
        override val displayOrder: Int = 0,
    @SerialName("is_active")
        override val isActive: Boolean? = null,
    @SerialName("include_all")
        override val includeAll: Boolean? = null,
    @SerialName("template_ids")
        override val templateIds: List<Int>? = null) : FieldModel()

@Serializable
sealed class FieldConfig {
    abstract val id: String
    abstract val context: Context
}

@Serializable
data class TextFieldConfig (
    override val id: String,
    override val context: Context,
    val options: TextOptions
) : FieldConfig()

@Serializable
data class DropdownFieldConfig (
    override val id: String,
    override val context: Context,
    val options: DropdownOptions
) : FieldConfig()

@Serializable
data class StepsFieldConfig (
    override val id: String,
    override val context: Context,
    val options: StepsOptions
) : FieldConfig()

@Serializable
data class StepResultsFieldConfig (
    override val id: String,
    override val context: Context,
    val options: StepResultsOptions
) : FieldConfig()

@Serializable
data class MultiSelectFieldConfig (
    override val id: String,
    override val context: Context,
    val options: MultiSelectOptions
) : FieldConfig()

@Serializable
abstract class Options {
    @SerialName("is_required")
    abstract val isRequired: Boolean
}

@Serializable
data class TextOptions(
    @SerialName("is_required")
        override val isRequired: Boolean,
    @SerialName("default_value")
        val defaultValue: String = "",
    val format: Format,
    val rows: String) : Options() {

    init {
        require(rows.isEmpty() || (Integer.parseInt(rows) in 3..10))
    }
}

@Serializable
data class DropdownOptions(
        @SerialName("is_required")
        override val isRequired: Boolean,
        @SerialName("default_value")
        val defaultValue: String,
        val items: String) : Options()


@Serializable
data class StepsOptions(
    @SerialName("is_required")
        override val isRequired: Boolean,
    val format: Format,
    val rows: String,
    @SerialName("has_expected")
        val hasExpected: Boolean) : Options() {

    init {
        require(rows.isEmpty() || (Integer.parseInt(rows) in 3..10))
    }
}

@Serializable
data class StepResultsOptions(
    @SerialName("is_required")
        override val isRequired: Boolean,
    val format: Format,
    val rows: String,
    @SerialName("has_expected")
        val hasExpected: Boolean,
    @SerialName("has_actual")
        val hasActual: Boolean) : Options() {
    init {
        require(rows.isEmpty() || (Integer.parseInt(rows) in 3..10))
    }
}

@Serializable
data class MultiSelectOptions(
        @SerialName("is_required")
        override val isRequired: Boolean,
        val items: String) : Options()

@Serializable
data class Context (
        @SerialName("is_global")
        val isGlobal: Boolean = false,
        @SerialName("project_ids")
        val projectIds: List<Int>? = null) {

    init {
        require((isGlobal && projectIds.isNullOrEmpty())
                || (!isGlobal && !projectIds.isNullOrEmpty()))
    }
}

@Serializable
enum class Format (val format: String) {
    plain("plain"),
    markdown("markdown")
}