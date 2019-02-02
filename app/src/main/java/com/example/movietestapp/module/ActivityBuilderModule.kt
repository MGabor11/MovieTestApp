package com.example.movietestapp.module

import com.example.movietestapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}
