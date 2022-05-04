package com.example.fishapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface FishListRepository {

    fun getFishList(): List<FishItem>

    fun addFishItemToFav(fish: FishItem)

    fun removeFromFavourites(fish: FishItem)

}