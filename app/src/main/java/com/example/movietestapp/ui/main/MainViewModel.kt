package com.example.movietestapp.ui.main

import android.os.Handler
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietestapp.api.MovieDetailResponse
import com.example.movietestapp.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    companion object {
        private const val DEFAULT_TYPING_DELAY = 500
    }

    val responseLiveData = MutableLiveData<List<MovieDetailResponse>>()
    val isEmptyLiveData = MutableLiveData<Boolean>()
    var progressCallback: ((Boolean, String?) -> Unit)? = null
    private var compositeDisposable = CompositeDisposable()
    private val handler = Handler()
    private var workRunnable: Runnable? = null

    init {
        isEmptyLiveData.value = true
    }

    private fun getMovies(query: String) {
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
        workRunnable?.let { handler.removeCallbacks(it) }
        if (!TextUtils.isEmpty(query)) {
            workRunnable = Runnable { getMovies(query.toString()) }
            handler.postDelayed(workRunnable, DEFAULT_TYPING_DELAY.toLong())
        } else {
            responseLiveData.value = ArrayList()
            isEmptyLiveData.value = true
        }
    }

    override fun onCleared() {
        handler.removeCallbacks(workRunnable)
        compositeDisposable.dispose()
        super.onCleared()
    }

}
