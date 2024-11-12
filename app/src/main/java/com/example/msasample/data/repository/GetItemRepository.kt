package com.example.msasample.data.repository

import com.example.msasample.data.api.ApiService
import javax.inject.Inject

class GetItemRepository @Inject constructor(
    private val apiService: ApiService,
) {

    suspend fun getNearByItem(
        item: String,
    ) =
        apiService.getNearbyItem(
            apiKey = "Bearer S41wqduF7FLHcSfwwQN4N3ikDrChA9gi5mfd3eywEYI9QajLyZsrhJzWxaZPOEtnrdl_ULNLD13opqYUXppYgIbMVx8dsqUAARQ9mpy5pVxIaye3vcaZc5p00zQyZ3Yx",
            term = item,
            location = "San Francisco",
            categories = item,
            limit = 10
        )
}