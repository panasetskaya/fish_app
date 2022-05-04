package com.example.fishapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fishapp.domain.FishItem
import com.example.fishapp.domain.FishListRepository
import io.reactivex.rxjava3.schedulers.Schedulers

object FishListRepositoryImpl: FishListRepository {

    private var fishList = mutableListOf<FishItem>()

    init {
        loadData()
    }

    override fun getFishList(): List<FishItem> {
        return fishList.toList()
    }

    override fun addFishItemToFav(fish: FishItem) {
        TODO()
    }

    override fun removeFromFavourites(fish: FishItem) {
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
                fishList = it
            },{
                Log.d("MyRes", "Failure while loading data: ${it.message}")
            })
    }
}