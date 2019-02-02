package com.example.movietestapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return (viewModelsMap[modelClass]
                ?: viewModelsMap.asIterable()
                        .firstOrNull { modelClass.isAssignableFrom(it.key) }
                        ?.value)
                ?.get() as? T

                ?: throw IllegalArgumentException("unknown model class $modelClass")
    }
}
