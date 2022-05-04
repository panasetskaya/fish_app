package com.example.fishapp.domain

class RemoveFromFavUseCase(private val repository: FishListRepository)  {
    suspend fun removeFromFav(fishItem: FishItem) {
        repository.removeFromFavourites(fishItem)
    }
}