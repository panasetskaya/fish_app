package com.example.fishapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface FishListRepository {

    suspend fun getFishList(): List<FishItem>

    suspend fun addFishItemToFav(fish: FishItem)

    suspend fun removeFromFavourites(fish: FishItem)

    suspend fun existsInFav(name: String?): Boolean
}