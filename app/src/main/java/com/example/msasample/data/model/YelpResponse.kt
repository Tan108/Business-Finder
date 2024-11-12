package com.example.msasample.data.model

import com.google.gson.annotations.SerializedName

data class YelpResponse(
    @SerializedName("businesses")
    val businesses: List<Business>,
)

data class Business(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("rating")
    val rating: Double,

    @SerializedName("location")
    val location: Location,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("image_url")
    val imageUrl: String,
)

data class Location(
    @SerializedName("address1")
    val address: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("state")
    val state: String,

    @SerializedName("zip_code")
    val zipCode: String,
)
