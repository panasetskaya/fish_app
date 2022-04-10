package com.example.fishapp.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class FishImage(
    @Json(name = "src")
    val imageUrl: String? = null,

    @Json(name = "alt")
    val description: String? = null
)
