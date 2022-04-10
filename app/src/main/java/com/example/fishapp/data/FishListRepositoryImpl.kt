package com.example.fishapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fishapp.domain.FishItem
import com.example.fishapp.domain.FishListRepository
import io.reactivex.rxjava3.schedulers.Schedulers

object FishListRepositoryImpl: FishListRepository {

    private val fishListLiveData = MutableLiveData<List<FishItem>>()
    init {
        loadData()
    }

    override fun getFishList(): MutableLiveData<List<FishItem>> {
        return fishListLiveData
    }

    override fun addFishItem(fish: FishItem) {
        TODO("Not yet implemented")
    }

    private fun loadData() {
        ApiFactory.apiService.getFishList()
            .map {
                it.toMutableList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                fishListLiveData.postValue(it)
            },{
                Log.d("MyRes", "Failure while loading data: ${it.message}")
            })
    }
}