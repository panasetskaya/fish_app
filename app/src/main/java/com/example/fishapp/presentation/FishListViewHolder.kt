package com.example.fishapp.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fishapp.R

class FishListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val rvFishName = view.findViewById<TextView>(R.id.textViewFishName)
    val rvFishScName = view.findViewById<TextView>(R.id.textViewScientificName)
    val imageViewFish = view.findViewById<ImageView>(R.id.imageViewFishImage)
    val rvpopulation = view.findViewById<TextView>(R.id.textViewPopulation)
    val rvLocation = view.findViewById<TextView>(R.id.textViewLocation)
}