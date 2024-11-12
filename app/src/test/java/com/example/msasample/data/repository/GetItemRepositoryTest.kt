package com.example.msasample.data.repository

import com.example.msasample.data.api.ApiService
import com.example.msasample.data.model.YelpResponse
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetItemRepositoryTest {

    private val mockItem = "pizza"
    private val mockApiService: ApiService = mockk()

    private val systemUnderTest = GetItemRepository(
        apiService = mockApiService
    )

    @Test
    fun `do when getNearbyItems get called`() = runBlocking {
        coEvery { mockApiService.getNearbyItem(any(), any(), any(), any(), any()) } returns YelpResponse(businesses = emptyList())

        val result = systemUnderTest.getNearByItem(mockItem)

        result shouldBe instanceOf<YelpResponse>()
        result.businesses shouldBe emptyList()
        coVerify {
            mockApiService.getNearbyItem(
                apiKey = any(),
                term = any(),
                location = any(),
                categories = any(),
                limit = any()
            )
        }
    }
}