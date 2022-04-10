package com.example.fishapp.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ImageGallery(
    @Json(name = "0")
    val first: List<FishImage>? = null,

    @Json(name = "1")
    val second: List<FishImage>? = null,

    @Json(name = "2")
    val third: List<FishImage>? = null
)
