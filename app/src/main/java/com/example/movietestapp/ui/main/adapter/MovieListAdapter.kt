package com.example.movietestapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietestapp.POSTER_PATH
import com.example.movietestapp.R
import com.example.movietestapp.api.MovieDetailResponse
import com.example.movietestapp.databinding.ItemMovieBinding

class MovieListAdapter : ListAdapter<MovieDetailResponse, RecyclerView.ViewHolder>(MovieDiffCallback()) {

    inner class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder as ViewHolder
        viewHolder.binding.title = getItem(position).title
        viewHolder.binding.imagePath = POSTER_PATH + getItem(position).posterPath
        viewHolder.binding.budget = getItem(position).budget.toString()
    }

}