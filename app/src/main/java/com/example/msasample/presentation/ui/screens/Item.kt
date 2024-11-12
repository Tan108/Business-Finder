package com.example.msasample.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.msasample.data.model.Business
import com.example.msasample.data.model.Location

@Composable
fun Item(
    business: Business,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .testTag("Item")
    ) {
        Row {
            Image(
                painter = rememberAsyncImagePainter(business.imageUrl),
                contentDescription = "Loaded Image",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Id : ${business.id}",
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Name : ${business.name}",
                    color = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Rating : ${business.rating}",
                    color = Color.Black
                )
            }

        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    Item(
        business = Business(
            id = "e",
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