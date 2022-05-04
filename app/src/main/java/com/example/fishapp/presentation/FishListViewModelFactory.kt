package com.example.fishapp.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FishListViewModelFactory(thisContext: Context): ViewModelProvider.Factory {

    val context = thisContext

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FishListViewModel(context as Application) as T
    }
}
