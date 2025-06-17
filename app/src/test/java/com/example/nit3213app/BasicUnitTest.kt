package com.example.nit3213app

import org.junit.Assert.assertEquals
import org.junit.Test

class BasicUnitTest {

    @Test
    fun `addition works correctly`() {
        val result = 2 + 3
        assertEquals(5, result)
    }

    @Test
    fun `string formats correctly`() {
        val name = "Student"
        val greeting = "Welcome, $name"
        assertEquals("Welcome, Student", greeting)
    }
}
