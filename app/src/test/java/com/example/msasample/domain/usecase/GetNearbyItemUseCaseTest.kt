package com.example.msasample.domain.usecase

import com.example.msasample.data.model.YelpResponse
import com.example.msasample.data.repository.GetItemRepository
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.instanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetNearbyItemUseCaseTest{

    private val mockItem = "pizza"
    private val mockGetItemRepository: GetItemRepository = mockk()

    private val systemUnderTest = GetNearbyItemUseCase(
        repository = mockGetItemRepository
    )

   @Test
   fun `do on invoke`() = runBlocking {
       coEvery { mockGetItemRepository.getNearByItem(any()) } returns YelpResponse(businesses = emptyList())

       val result = systemUnderTest(mockItem)

       result shouldBe instanceOf<YelpResponse>()
       result.businesses shouldBe emptyList()
       coVerify {
           mockGetItemRepository.getNearByItem(
               item = any()
           )
       }
   }
}