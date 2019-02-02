package com.example.movietestapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

@BindingAdapter(value = ["adapter", "layoutManager", "list"], requireAll = false)
fun <T> setRecyclerViewData(
    recyclerView: RecyclerView,
    adapter: ListAdapter<T, RecyclerView.ViewHolder>?,
    layoutManager: RecyclerView.LayoutManager?,
    list: List<T>?
) {
    adapter?.apply {
        recyclerView.layoutManager = layoutManager ?: LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = this
        submitList(list)
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).into(imageView)
}
