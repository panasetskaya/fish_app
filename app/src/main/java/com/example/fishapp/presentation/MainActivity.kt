package com.example.fishapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.fishapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var rVFishList: RecyclerView
    private lateinit var viewModel: FishListViewModel
    private lateinit var fishListAdapter: FishListAdapter
    private lateinit var pBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rVFishList = findViewById(R.id.rVFishList)
        pBar = findViewById(R.id.progressBarFishItem)
        viewModel = ViewModelProvider(this)[FishListViewModel::class.java]
        fishListAdapter = FishListAdapter()
        rVFishList.adapter = fishListAdapter
        viewModel.fishListLiveData.observe(this) {
            fishListAdapter.submitList(it)
            pBar.visibility = View.GONE
        }
        setupClickListeners()
    }

    fun setupClickListeners() {
        fishListAdapter.onWhiteHeartClickListener = {viewModel.addToFav(it)}
        fishListAdapter.onRedHeartClickListener = {viewModel.addToFav(it)}
    }
}