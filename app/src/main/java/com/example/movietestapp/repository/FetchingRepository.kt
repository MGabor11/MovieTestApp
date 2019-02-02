package com.example.movietestapp.repository

import com.example.movietestapp.api.MovieApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchingRepository @Inject constructor(private val api: MovieApi) {

    /*fun getRepoObservable(): Single<List<Repository>> {
        return api.listRepos("MGabor11")
    }*/

}