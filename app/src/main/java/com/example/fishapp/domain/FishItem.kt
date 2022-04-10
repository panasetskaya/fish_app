package com.example.fishapp.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class FishItem(

    @Json(name = "Species Name")
    val name: String? = null,

    @Json(name = "Scientific Name")
    val scientificName: String? = null,

    @Json(name = "Image Gallery")
    val imageGallery: Any? = null,

    @Json(name = "Location")
    val location: String? = null,

    @Json(name = "Population")
    val population: String? = null
) {
    val imageGalleryString = imageGallery?.toString()
    val indexOne = imageGalleryString?.indexOf("src=")
    val indexTwo = imageGalleryString?.indexOf(", alt=")
    val imageUrl: String? = indexTwo?.let { indexOne?.let { it1 -> imageGalleryString?.substring(it1+4, it) } }
}
