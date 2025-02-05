package com.example.githubreposappdepiround2.data.dataSources.remote

import android.util.Log
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api.GithubApi
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.GithubReposDataModel
import com.example.githubreposappdepiround2.di.NetworkModule

class GithubReposRemoteDataSource(
    private val githubApi: GithubApi = NetworkModule.provideGithubApi(
        NetworkModule.provideRetrofitInstance()
    )
) {
    fun fetchGithubRepos(): GithubReposDataModel{
        return try {
            githubApi.fetchGithubRepos().body() as GithubReposDataModel
        } catch (e:Exception) {
            Log.d("githubReposList", "exception in remoteDS: ${e.message}")
            throw e
        }
    }
}