package com.example.movietestapp.api


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: String, @Query("api_key") apiKey: String): Observable<MovieDetailResponse>

    @GET("search/movie")
    fun getMovieList(@Query("api_key") apiKey: String, @Query("query") query: String): Observable<MovieListResponse>

}