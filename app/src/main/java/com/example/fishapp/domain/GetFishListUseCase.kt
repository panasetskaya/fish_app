package com.example.fishapp.domain

import androidx.lifecycle.MutableLiveData

class GetFishListUseCase(private val repository: FishListRepository) {

    suspend fun getFishList(): List<FishItem> {
        return repository.getFishList()
    }
}