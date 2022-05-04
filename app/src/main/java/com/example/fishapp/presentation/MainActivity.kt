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
        viewModel = ViewModelProvider(this, FishListViewModelFactory(application))[FishListViewModel::class.java]
        fishListAdapter = FishListAdapter()
        rVFishList.adapter = fishListAdapter
        viewModel.getFishList()
        viewModel.fishListLiveData.observe(this) {
            fishListAdapter.submitList(it)
            pBar.visibility = View.GONE
        }
        fishListAdapter.onHeartClickListener = {
            if (viewModel.checkInFav(it.name)) {
                viewModel.removeFromFav(it)
            } else {
                viewModel.addToFav(it)
            }
        }
    }
}