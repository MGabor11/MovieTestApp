package com.example.movietestapp.api

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    val id: Int, val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val budget: Long
)
