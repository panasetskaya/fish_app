package com.example.fishapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class FishItem(

    @PrimaryKey
    @Json(name = "Species Name")
    var name: String,

    @Json(name = "Scientific Name")
    var scientificName: String? = null,

    @Json(name = "Image Gallery")
    var imageGallery: Any? = null,

    @Json(name = "Location")
    val location: String? = null,

    @Json(name = "Population")
    var population: String? = null,
) {
    var imageGalleryString = imageGallery?.toString()
    var indexOne = imageGalleryString?.indexOf("src=")
    var indexTwo = imageGalleryString?.indexOf(", alt=")
    var imageUrl: String? = indexTwo?.let { indexOne?.let { it1 -> imageGalleryString?.substring(it1+4, it) } }
    var cutLocation: String? =
        if (location!=null) {
            var indexUlOne = location.indexOf("<li>")+4
            var indexUlTwo = location.indexOf("</li>")
            if (indexUlOne!=-1 && indexUlTwo!=-1) {
                indexUlOne.let { indexUlTwo.let { it1 -> location.substring(it, it1) } }
            } else null
        } else null

    var favourite: Boolean = false
}

