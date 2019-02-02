package com.example.movietestapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movietestapp.repository.FetchingRepository
import com.example.movietestapp.vo.MovieListItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(private val fetchingRepository: FetchingRepository) : ViewModel() {

    val responseLiveData = MutableLiveData<List<MovieListItem>>()
    var progressCallback: ((Boolean, String?) -> Unit)? = null
    private var compositeDisposable = CompositeDisposable()

    /*val budgets by lazy {
        budgetCommonRepository.getAllBudgetLiveData()
    }

    fun deleteBudget(budgetObject: BudgetObject): LiveData<List<BudgetObject>> {
        return budgetCommonRepository.deleteBudget(budgetObject)
    }

    fun isBudgetRemained(list: List<BudgetObject>): Boolean {
        if (list.isNotEmpty()) {
            return true
        }
        return false
    }*/

    fun getMovies() {
       /* progressCallback?.invoke(true, null)
        val disposable = fetchingRepository.getRepoObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ list ->
                responseLiveData.value = list
                progressCallback?.invoke(false, null)
            }, { error ->
                progressCallback?.invoke(false, error.localizedMessage)
            })
        compositeDisposable.add(disposable)*/
//https://stackoverflow.com/questions/36208331/how-to-use-observable-fromcallable-with-a-checked-exception
        //https://android.jlelse.eu/kotlin-coroutines-and-retrofit-e0702d0b8e8f
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}
