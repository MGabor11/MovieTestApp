package com.example.movietestapp.module

import com.example.movietestapp.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): MainFragment

}
