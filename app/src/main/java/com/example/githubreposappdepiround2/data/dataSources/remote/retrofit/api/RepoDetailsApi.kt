package com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api


import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.repo_details.RepositoryDetailsDataModel
import com.example.githubreposappdepiround2.data.Constants.Companion.OWNER_KEY
import com.example.githubreposappdepiround2.data.Constants.Companion.REPO_NAME_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoDetailsApi {
    @GET("repos/{$OWNER_KEY}/{$REPO_NAME_KEY}")
    suspend fun fetchRepoDetails(
        @Path(OWNER_KEY) owner: String,
        @Path(REPO_NAME_KEY) name: String
    ): Response<RepositoryDetailsDataModel>
}