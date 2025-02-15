package com.example.githubreposappdepiround2.di

import com.example.githubreposappdepiround2.data.Constants.Companion.BASE_URL
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGithubApi(
        retrofit: Retrofit,
    ): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }

}