package com.example.fishapp.data

import com.example.fishapp.domain.FishItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("species")
    suspend fun getFishList(): List<FishItem>
}