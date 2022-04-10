package com.example.fishapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.fishapp.R

class MainActivity : AppCompatActivity() {

    lateinit var rVFishList: RecyclerView
    lateinit var viewModel: FishListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rVFishList = findViewById(R.id.rVFishList)
        viewModel = ViewModelProvider(this)[FishListViewModel::class.java]
        viewModel.fishListLiveData.observe(this) {

            Log.d("MyRes", it.toString())
        }

    }
}