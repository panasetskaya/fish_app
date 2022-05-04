package com.example.fishapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fishapp.data.FishListRepositoryImpl
import com.example.fishapp.domain.AddFishItemToFavUseCase
import com.example.fishapp.domain.FishItem
import com.example.fishapp.domain.GetFishListUseCase

class FishListViewModel: ViewModel() {

    private val repository = FishListRepositoryImpl //я знаю, что не надо зависеть от data-слоя, но с DI еще не разобралась:)

    private val addFishItemToFavUseCase = AddFishItemToFavUseCase(repository)

    private val fishList = GetFishListUseCase(repository).getFishList()

    val _fishListLiveData = MutableLiveData<List<FishItem>>()

    val fishListLiveData: LiveData<List<FishItem>> = _fishListLiveData

    fun addToFav(fish: FishItem) {
        val newFish = fish.copy(isFavourite = !fish.isFavourite)
        addFishItemToFavUseCase.addFishItemToFav(newFish)
    }

    fun getList() {
        _fishListLiveData.postValue(fishList)
    }
}