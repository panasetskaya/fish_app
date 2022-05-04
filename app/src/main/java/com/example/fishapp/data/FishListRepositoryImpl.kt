package com.example.fishapp.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fishapp.domain.FishItem
import com.example.fishapp.domain.FishListRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FishListRepositoryImpl(context: Context): FishListRepository {

    private val database = FavouriteFishDatabase.getInstance(context)

    override suspend fun getFishList(): List<FishItem> {
        Log.i("MyRes", ApiFactory.apiService.getFishList().toString())
        return ApiFactory.apiService.getFishList()
    }

    override suspend fun addFishItemToFav(fish: FishItem) {
        database.fishDao().addFishToFav(fish)
    }

    override suspend fun removeFromFavourites(fish: FishItem) {
        database.fishDao().removeFishFromFav(fish)
    }

    override suspend fun existsInFav(name: String?): Boolean {
        return database.fishDao().existsInFav(name)
    }
}