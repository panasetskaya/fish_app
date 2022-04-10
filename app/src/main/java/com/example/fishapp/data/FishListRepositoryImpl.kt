package com.example.fishapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fishapp.domain.FishItem
import com.example.fishapp.domain.FishListRepository

object FishListRepositoryImpl: FishListRepository {

    private val fishList = mutableListOf<FishItem>()
    private val fishListLiveData = MutableLiveData<List<FishItem>>()

    override fun getFishList(): LiveData<List<FishItem>> {
        TODO("Not yet implemented")
        return fishListLiveData
    }

    override fun addFishItem(fish: FishItem) {
        TODO("Not yet implemented")
    }

    private fun updateList() {
        fishListLiveData.postValue(fishList.toList())
    }
}