package com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api

import com.example.githubreposappdepiround2.data.Constants.Companion.GITHUB_REPOS_ENDPOINT
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {
    @GET(GITHUB_REPOS_ENDPOINT)
    fun fetchGithubRepos():Response<GithubReposDataModel>
}