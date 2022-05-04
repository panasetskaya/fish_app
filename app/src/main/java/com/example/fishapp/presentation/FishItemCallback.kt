package com.example.fishapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.fishapp.domain.FishItem

class FishItemCallback: DiffUtil.ItemCallback<FishItem>() {
    override fun areItemsTheSame(oldItem: FishItem, newItem: FishItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: FishItem, newItem: FishItem): Boolean {
        return oldItem == newItem
    }
}