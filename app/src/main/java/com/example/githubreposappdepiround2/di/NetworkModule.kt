package com.example.githubreposappdepiround2.di

import com.example.githubreposappdepiround2.data.Constants.Companion.BASE_URL
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api.GithubApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    companion object {
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun provideGithubApi(
            retrofit: Retrofit
        ):GithubApi {
            return retrofit.create(GithubApi::class.java)
        }
    }

}