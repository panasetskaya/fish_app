package com.example.fishapp.domain

class AddFishItemToFavUseCase(private val repository: FishListRepository) {

    fun addFishItemToFav(fish: FishItem) {
        repository.addFishItemToFav(fish)
    }
}