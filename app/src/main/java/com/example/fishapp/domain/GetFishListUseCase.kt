package com.example.fishapp.domain

class GetFishListUseCase(private val repository: FishListRepository) {

    fun getFishList() {
        repository.getFishList()
    }
}