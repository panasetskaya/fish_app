package com.example.fishapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.fishapp.R
import com.example.fishapp.domain.FishItem

class FishListAdapter: ListAdapter<FishItem, FishListViewHolder>(FishItemCallback()) {

    var onHeartClickListener: ((FishItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fish_item, parent, false)
        return FishListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FishListViewHolder, position: Int) {
        val fishItem = getItem(position)
        val placeholder = R.drawable.fish
        setHearts(holder, position)
        holder.rvFishName.text = fishItem.name
        holder.rvFishScName.text = fishItem.scientificName
        holder.rvpopulation.text = fishItem.population
        holder.rvLocation.text = fishItem.cutLocation
        Glide.with(holder.view.context).load(fishItem.imageUrl).circleCrop()
            .placeholder(placeholder).into(holder.imageViewFish)
        setupListeners(holder, position, fishItem)
    }

    fun setupListeners(holder: FishListViewHolder, position: Int, fishItem: FishItem) {
        holder.rvImageViewFav.setOnClickListener {
            changeOfHeart(holder)
            onHeartClickListener?.invoke(fishItem)
        }
        holder.rvImageViewNotFav.setOnClickListener {
            changeOfHeart(holder)
            onHeartClickListener?.invoke(fishItem)
        }
    }

    fun changeOfHeart(holder: FishListViewHolder) {
        if (holder.rvImageViewFav.visibility == View.VISIBLE) {
            holder.rvImageViewNotFav.visibility = View.VISIBLE
            holder.rvImageViewFav.visibility = View.INVISIBLE
        } else {
            holder.rvImageViewNotFav.visibility = View.INVISIBLE
            holder.rvImageViewFav.visibility = View.VISIBLE
        }
    }

    fun setHearts(holder: FishListViewHolder, position: Int) {
        if (getItem(position).isFavourite) {
            holder.rvImageViewNotFav.visibility = View.INVISIBLE
            holder.rvImageViewFav.visibility = View.VISIBLE
        } else {
            holder.rvImageViewNotFav.visibility = View.VISIBLE
            holder.rvImageViewFav.visibility = View.INVISIBLE
        }
    }
}