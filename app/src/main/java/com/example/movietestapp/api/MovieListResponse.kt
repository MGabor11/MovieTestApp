package com.example.movietestapp.api

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val results: List<MovieItem>
) {
    data class MovieItem(
        val id: Int
    )
}