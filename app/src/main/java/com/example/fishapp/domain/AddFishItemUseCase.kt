package com.example.fishapp.domain

class AddFishItemUseCase(private val repository: FishListRepository) {

    fun addFishItem(fish: FishItem) {
        repository.addFishItem(fish)
    }
}