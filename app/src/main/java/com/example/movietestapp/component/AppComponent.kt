package com.example.movietestapp.component

import com.example.movietestapp.MyApplication
import com.example.movietestapp.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, ViewModelFactoryModule::class, ViewModelModule::class, AndroidSupportInjectionModule::class, ActivityBuilderModule::class])
interface AppComponent : AndroidInjector<MyApplication> {

    override fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MyApplication): Builder

        fun build(): AppComponent
    }
}
