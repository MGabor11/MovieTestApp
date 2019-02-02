package com.example.movietestapp.module

import androidx.lifecycle.ViewModel
import com.example.movietestapp.ActivitySharedViewModel
import com.example.movietestapp.ui.main.MainViewModel
import com.betsson.budgetapp.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ActivitySharedViewModel::class)
    abstract fun bindActivitySharedViewModel(activitySharedViewModel: ActivitySharedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

}
