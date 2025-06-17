package com.example.nit3213app

import org.junit.Assert.assertEquals
import org.junit.Test

class LoginRequestTest {

    @Test
    fun `loginRequest stores username and password correctly`() {
        val testUsername = "TestUser"
        val testPassword = "s12345678"
        val request = LoginRequest(testUsername, testPassword)

        assertEquals(testUsername, request.username)
        assertEquals(testPassword, request.password)
    }
}
