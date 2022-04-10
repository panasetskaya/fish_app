package com.example.fishapp.domain

import androidx.lifecycle.LiveData

interface FishListRepository {

    fun getFishList(): LiveData<List<FishItem>>

    fun addFishItem(fish: FishItem)

}