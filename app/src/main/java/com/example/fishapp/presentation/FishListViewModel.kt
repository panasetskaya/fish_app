package com.example.fishapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.fishapp.data.FishListRepositoryImpl
import com.example.fishapp.domain.*
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.launch
import java.util.*

class FishListViewModel(application: Application): AndroidViewModel(application) {

    private val repository = FishListRepositoryImpl(application)

    private val addFishItemToFavUseCase = AddFishItemToFavUseCase(repository)

    private val removeFromFavUseCase = RemoveFromFavUseCase(repository)

    private val checkInFavUseCase = CheckInFavUseCase(repository)

    private var exists = false

    private val _fishListLiveData = MutableLiveData<List<FishItem>>()

    val fishListLiveData: LiveData<List<FishItem>> = _fishListLiveData

    fun getFishList() {
        viewModelScope.launch {
            _fishListLiveData.postValue(GetFishListUseCase(repository).getFishList())
        }
    }

    fun addToFav(fish: FishItem) {
        viewModelScope.launch {
            addFishItemToFavUseCase.addFishItemToFav(fish)
        }
    }

    fun removeFromFav(fish: FishItem) {
        viewModelScope.launch {
            removeFromFavUseCase.removeFromFav(fish)
        }
    }

    fun checkInFav(name: String?):Boolean {
        viewModelScope.launch {
            exists = checkInFavUseCase.checkInFav(name)
        }
        return exists
    }
}