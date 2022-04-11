package com.example.fishapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.fishapp.R
import com.example.fishapp.domain.FishItem


class FishListAdapter: ListAdapter<FishItem, FishListViewHolder>(FishItemCallback()) {

    var onRedHeartClickListener: ((FishItem) -> Unit)? = null
    var onWhiteHeartClickListener: ((FishItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fish_item, parent, false)
        return  FishListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FishListViewHolder, position: Int) {
        val fishItem = getItem(position)
        val placeholder = R.drawable.fish
        changeOfHeart(holder, position)
        holder.rvFishName.text = fishItem.name
        holder.rvFishScName.text = fishItem.scientificName
        holder.rvpopulation.text = fishItem.population
        holder.rvLocation.text = fishItem.cutLocation
        Glide.with(holder.view.context).load(fishItem.imageUrl).circleCrop()
            .placeholder(placeholder).into(holder.imageViewFish)
        holder.rvImageViewNotFav.setOnClickListener {
            onWhiteHeartClickListener?.invoke(fishItem)
            changeOfHeart(holder, position)
            true
        }
        holder.rvImageViewFav.setOnClickListener {
            onRedHeartClickListener?.invoke(fishItem)
            changeOfHeart(holder, position)
            true

        }
    }

    fun changeOfHeart(holder: FishListViewHolder, position: Int) {
        if (getItem(position).isFavourite) {
            holder.rvImageViewNotFav.visibility = View.GONE
            holder.rvImageViewFav.visibility = View.VISIBLE
        } else {
            holder.rvImageViewNotFav.visibility = View.VISIBLE
            holder.rvImageViewFav.visibility = View.GONE
        }
    }
}