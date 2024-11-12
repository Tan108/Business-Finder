package com.example.msasample

import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.msasample.data.model.Business
import com.example.msasample.data.model.Location
import com.example.msasample.presentation.ui.screens.Item
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposableItemListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testItemOnUi(){

        composeTestRule.setContent {
            Item(
                business = Business(
                    id = "abc",
                    name = "Pizzza",
                    rating = 2.3,
                    location = Location(
                        address = "San Francico",
                        city = "",
                        state = "",
                        zipCode = ""
                    ),
                    phone = "123456",
                    imageUrl = ""
                )
            )
        }

        composeTestRule.onNodeWithText("Pizzza")
            .isDisplayed()

    }

}