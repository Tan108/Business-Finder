package com.example.msasample.presentation.viewmodel

import com.example.msasample.data.model.YelpResponse
import com.example.msasample.domain.usecase.GetNearbyItemUseCase
import com.example.msasample.presentation.state.GetItemState
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BusinessFinderViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val mockGetNearbyItemUseCase: GetNearbyItemUseCase = mockk()

    private lateinit var systemUnderTest: BusinessFinderViewModel

    private fun assumeViewModelCreated() {
        systemUnderTest = BusinessFinderViewModel(
            getNearbyItemUseCase = mockGetNearbyItemUseCase
        )
    }

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        assumeViewModelCreated()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `do on getItem Success`() = runTest {
        coEvery { mockGetNearbyItemUseCase(eq("pizza")) } returns  YelpResponse(businesses = emptyList())
        coEvery { mockGetNearbyItemUseCase(eq("juice")) } returns  YelpResponse(businesses = emptyList())

        systemUnderTest.getItem()

        advanceUntilIdle()

        systemUnderTest.getItemState.value shouldBe GetItemState.Success(emptyList())
        coVerify {
            mockGetNearbyItemUseCase(
                item = any()
            )
        }
    }

    @Test
    fun `do on getItem Error`() = runTest {
        coEvery { mockGetNearbyItemUseCase(eq("pizza")) }  throws  Exception("Network Error")
        coEvery { mockGetNearbyItemUseCase(eq("juice")) }  throws  Exception("Network Error")

        systemUnderTest.getItem()

        advanceUntilIdle()

        systemUnderTest.getItemState.value shouldBe GetItemState.Error("Network Error")
        coVerify {
            mockGetNearbyItemUseCase(
                item = any()
            )
        }
    }
}