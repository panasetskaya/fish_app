package com.example.fishapp.presentation

import androidx.lifecycle.ViewModel
import com.example.fishapp.data.FishListRepositoryImpl
import com.example.fishapp.domain.AddFishItemToFavUseCase
import com.example.fishapp.domain.FishItem
import com.example.fishapp.domain.GetFishListUseCase

class FishListViewModel: ViewModel() {

    private val repository = FishListRepositoryImpl //я знаю, что не надо зависеть от data-слоя, но с DI еще не разобралась:)

    private val getFishListUseCase = GetFishListUseCase(repository)

    private val addFishItemToFavUseCase = AddFishItemToFavUseCase(repository)

    val fishListLiveData = getFishListUseCase.getFishList()

    fun addToFav(fish: FishItem) = addFishItemToFavUseCase.addFishItemToFav(fish)
}