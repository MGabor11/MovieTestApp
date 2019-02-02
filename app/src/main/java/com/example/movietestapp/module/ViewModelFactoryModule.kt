package com.example.movietestapp.module

import androidx.lifecycle.ViewModelProvider
import com.example.movietestapp.ui.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
