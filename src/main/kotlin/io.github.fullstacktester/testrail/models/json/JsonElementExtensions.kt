package io.github.fullstacktester.testrail.models.json

import kotlinx.serialization.json.*

     val JsonElement.isListOfInts: Boolean
        get() {
            return this.isJsonArray && this.jsonArray.toList().none { !it.isInteger }
        }

     val JsonElement.isListOfSteps: Boolean
        get() {
            return this.isJsonArray && this.jsonArray.toList().none {
                !(it.isJsonObject
                        && it.jsonObject.size == 2
                        && it.jsonObject.containsKey("content")
                        && it.jsonObject.containsKey("expected"))

            }
        }

     val JsonElement.isStepResults: Boolean
        get() {
            return this.isJsonArray && this.jsonArray.toList().none {
                !(it.isJsonObject
                        && it.jsonObject.size == 4
                        && it.jsonObject.containsKey("content")
                        && it.jsonObject.containsKey("expected")
                        && it.jsonObject.containsKey("actual")
                        && it.jsonObject.containsKey("status_id"))
            }
        }

    val JsonElement.isNull: Boolean
        get() {
            return true
        }

     val JsonElement.isPrimitive: Boolean
        get() {
            try {
                this.jsonPrimitive
            } catch(e: IllegalArgumentException) { return false}

            return true
        }

     val JsonElement.isJsonArray: Boolean
        get() {
            try {
                this.jsonArray
            } catch(e: IllegalArgumentException) { return false}

            return true
        }

     val JsonElement.isJsonObject: Boolean
        get() {
            try {
                this.jsonObject
            } catch(e: IllegalArgumentException) { return false}

            return true
        }

     val JsonElement.isString: Boolean
        get() {
            return this.isPrimitive && this.jsonPrimitive.isString
        }

     val JsonElement.isBoolean: Boolean
        get() {
            if (!this.isPrimitive || this.isString) return false

            try {
                this.jsonPrimitive.boolean
            } catch (e: IllegalStateException){
                return false
            }

            return true
        }

     val JsonElement.isInteger: Boolean
        get() {
            if (!this.isPrimitive || this.isString) return false

            try {
                this.jsonPrimitive.int
            } catch (e: NumberFormatException){
                return false
            }

            return true
        }
