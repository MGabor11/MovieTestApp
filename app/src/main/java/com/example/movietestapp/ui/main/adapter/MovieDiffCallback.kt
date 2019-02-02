package com.example.movietestapp.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.movietestapp.vo.MovieListItem

class MovieDiffCallback : DiffUtil.ItemCallback<MovieListItem>() {
    override fun areItemsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
        return oldItem == newItem
    }
}