package com.example.fishapp.domain

class CheckInFavUseCase(private val repository: FishListRepository)  {
    suspend fun checkInFav(name: String?): Boolean {
        return repository.existsInFav(name)
    }
}