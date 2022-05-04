package com.example.fishapp.data

import androidx.room.TypeConverter

class FishTypeConverter {

    @TypeConverter
    fun fromImageGallery(imageGallery: Any?): String? {
        return imageGallery?.toString()
    }

    @TypeConverter
    fun toImageGallery(image: String?): Any {
        return image as Any
    }
}