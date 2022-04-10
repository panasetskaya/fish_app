package com.example.fishapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.fishapp.R
import com.example.fishapp.domain.FishItem


class FishListAdapter: ListAdapter<FishItem, FishListViewHolder>(FishItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fish_item, parent, false)
        return  FishListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FishListViewHolder, position: Int) {
        val fishItem = getItem(position)
        val placeholder = R.drawable.ic_launcher_background
        holder.rvFishName.text = fishItem.name
        holder.rvFishScName.text = fishItem.scientificName
        holder.rvpopulation.text = fishItem.population
        holder.rvLocation.text = fishItem.cutLocation
        Glide.with(holder.view.context).load(fishItem.imageUrl)
            .placeholder(placeholder).into(holder.imageViewFish)
    }
}