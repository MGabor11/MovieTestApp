package com.example.movietestapp.repository

import com.example.movietestapp.API_KEY
import com.example.movietestapp.api.MovieApi
import com.example.movietestapp.api.MovieDetailResponse
import com.example.movietestapp.api.MovieListResponse
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val api: MovieApi) {

    fun getMovies(query: String): Single<List<MovieDetailResponse>> {
        return api.getMovieList(API_KEY, query)
            .map { t: MovieListResponse -> t.results }
            .flatMap { list: List<MovieListResponse.MovieItem> -> Observable.fromIterable(list) }
            .flatMap { item ->
                Observables.zip(
                    Observable.just(item),
                    api.getMovieDetail(item.id.toString(), API_KEY)
                ) { _, detailItem -> detailItem }
            }.toList()
    }

   /* fun getMovies(query: String): Single<List<MovieDetailResponse>> {
        return api.getMovieList(API_KEY, query)
            .map { t: MovieListResponse -> t.results }
            .concatMapIterable { list -> list }
            .concatMap { item -> api.getMovieDetail(item.id.toString(), API_KEY)}.toList()
    }*/

}