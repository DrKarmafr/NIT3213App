package com.example.nit3213app

import com.google.common.truth.Truth.assertThat
import com.google.gson.JsonParser
import org.junit.Test

class DashboardItemParsingTest {

    @Test
    fun parseJsonObject_toFieldsMap_containsAllEntries() {
        val json = """
            {
              "code": "CS101",
              "name": "Intro to CS",
              "author": "Dr. Smith",
              "yearOrCredit": 3,
              "description": "Fundamentals of programming"
            }
        """.trimIndent()
        val jsonObj = JsonParser.parseString(json).asJsonObject
        val map = jsonObj.entrySet().associate { (key, value) ->
            key to if (value.isJsonPrimitive) value.asString else value.toString()
        }

        assertThat(map["code"]).isEqualTo("CS101")
        assertThat(map["name"]).isEqualTo("Intro to CS")
        assertThat(map["author"]).isEqualTo("Dr. Smith")
        assertThat(map["yearOrCredit"]).isEqualTo("3")
        assertThat(map["description"]).isEqualTo("Fundamentals of programming")
    }
}
