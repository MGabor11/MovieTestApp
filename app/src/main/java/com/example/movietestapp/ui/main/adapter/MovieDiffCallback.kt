package com.example.movietestapp.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.movietestapp.api.MovieDetailResponse

class MovieDiffCallback : DiffUtil.ItemCallback<MovieDetailResponse>() {
    override fun areItemsTheSame(oldItem: MovieDetailResponse, newItem: MovieDetailResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieDetailResponse, newItem: MovieDetailResponse): Boolean {
        return oldItem == newItem
    }
}