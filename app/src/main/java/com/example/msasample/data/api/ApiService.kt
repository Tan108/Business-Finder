package com.example.msasample.data.api

import com.example.msasample.data.model.YelpResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("businesses/search")
    suspend fun getNearbyItem(
        @Header("Authorization") apiKey: String,
        @Query("term") term: String,
        @Query("location") location: String,
        @Query("categories") categories: String,
        @Query("limit") limit: Int,
    ): YelpResponse
}