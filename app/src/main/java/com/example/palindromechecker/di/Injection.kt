package com.example.palindromechecker.di

import android.content.Context
import com.example.palindromechecker.data.Repository
import com.example.palindromechecker.data.remote.ApiConfig

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}