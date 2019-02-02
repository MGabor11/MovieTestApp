package com.example.movietestapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietestapp.api.MovieDetailResponse
import com.example.movietestapp.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    val responseLiveData = MutableLiveData<List<MovieDetailResponse>>()
    val isEmptyLiveData = MutableLiveData<Boolean>()
    var progressCallback: ((Boolean, String?) -> Unit)? = null
    private var compositeDisposable = CompositeDisposable()

    init {
        isEmptyLiveData.value = true
    }

    fun getMovies(query: String) {
        progressCallback?.invoke(true, null)
        val disposable = movieRepository.getMovies(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ list ->
                responseLiveData.value = list
                progressCallback?.invoke(false, null)
            }, { error ->
                progressCallback?.invoke(false, error.localizedMessage)
            })
        compositeDisposable.add(disposable)

    }

    fun onQueryChanged(query: CharSequence) {
        getMovies(query.toString())
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}
