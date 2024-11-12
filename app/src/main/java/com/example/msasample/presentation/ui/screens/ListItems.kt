package com.example.msasample.presentation.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.msasample.presentation.state.GetItemState
import com.example.msasample.presentation.viewmodel.BusinessFinderViewModel

@Composable
fun ListItems(
    viewModel: BusinessFinderViewModel = hiltViewModel(),
) {
    val state by viewModel.getItemState.collectAsState()

    when (state) {
        is GetItemState.Loading -> Loading()
        is GetItemState.Success -> LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 50.dp,
                    start = 5.dp
                )
        ) {
            items((state as GetItemState.Success).listOfBusiness, key = { it.id }) {
                Item(
                    business = it
                )
                HorizontalDivider(
                    color = Color.Gray,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }

        is GetItemState.Error -> Error()
    }
}



