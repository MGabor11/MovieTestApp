package com.example.movietestapp.module

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.preference.PreferenceManager
import android.content.SharedPreferences
import com.example.movietestapp.MyApplication


@Module
class AppModule {
    /*@Singleton
    @Provides
    fun provideDb(app: BudgetApplication): BudgetDb {
        return Room
            .databaseBuilder(app, BudgetDb::class.java, "budget.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBudgetDao(db: BudgetDb): BudgetDao {
        return db.budgetDao()
    }*/

    @Singleton
    @Provides
    fun provideSharedPreferences(app: MyApplication): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app)
    }

    @Singleton
    @Provides
    fun provideSharedPreferencesEditor(sharedPreferences: SharedPreferences): SharedPreferences.Editor {
        return sharedPreferences.edit()
    }

}