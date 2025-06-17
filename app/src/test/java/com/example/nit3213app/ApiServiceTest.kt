package com.example.nit3213app

import com.google.gson.JsonObject
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import retrofit2.Call
import retrofit2.Response

class ApiServiceTest {

    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        apiService = mock(ApiService::class.java)
    }

    @Test
    fun `login returns keypass on success`() {
        val mockCall = mock(Call::class.java) as Call<LoginResponse>
        val loginResponse = LoginResponse("courses")
        val response = Response.success(loginResponse)

        `when`(apiService.login(LoginRequest("TestUser", "s12345678")))
            .thenReturn(mockCall)
        `when`(mockCall.execute()).thenReturn(response)

        val actualResponse = apiService.login(LoginRequest("TestUser", "s12345678")).execute()
        assertEquals("courses", actualResponse.body()?.keypass)
    }

    @Test
    fun `getDashboardItems returns JSON data`() {
        val mockCall = mock(Call::class.java) as Call<JsonObject>
        val jsonObject = JsonObject()
        jsonObject.addProperty("entityTotal", 5)
        val response = Response.success(jsonObject)

        `when`(apiService.getDashboardItems("courses", "TestUser", "s12345678"))
            .thenReturn(mockCall)
        `when`(mockCall.execute()).thenReturn(response)

        val result = apiService.getDashboardItems("courses", "TestUser", "s12345678").execute()
        assertEquals(5, result.body()?.get("entityTotal")?.asInt)
    }
}
