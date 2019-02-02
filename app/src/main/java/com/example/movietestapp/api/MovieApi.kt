package com.example.movietestapp.api


import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: String, @Query("api_key") apiKey: String): Single<List<MovieListResponse>>

    @GET("/search/movie")
    fun getMovieList(@Query("api_key") apiKey: String, @Query("query") query: String): Single<MovieDetailResponse>


    /*@GET("Search") //i.e https://api.test.com/Search?
    Call<Products> getProducts(@Query("one") String one, @Query("two") String two,
    @Query("key") String key)*/
}