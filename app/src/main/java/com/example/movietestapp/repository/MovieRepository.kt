package com.example.movietestapp.repository

import com.example.movietestapp.API_KEY
import com.example.movietestapp.api.MovieApi
import com.example.movietestapp.api.MovieDetailResponse
import com.example.movietestapp.api.MovieListResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val api: MovieApi) {

    fun getMovies(query: String): Single<List<MovieDetailResponse>> {
        return api.getMovieList(API_KEY, query)
            .map { t: MovieListResponse -> t.results }
            .flatMap { list: List<MovieListResponse.MovieItem> -> Observable.fromIterable(list) }
            .flatMap { item ->
                Observable.zip(
                    Observable.just(item),
                    api.getMovieDetail(item.id.toString(), API_KEY),
                    BiFunction { _: MovieListResponse.MovieItem, detailItem: MovieDetailResponse ->
                        detailItem
                    })
            }.toList()
    }

}