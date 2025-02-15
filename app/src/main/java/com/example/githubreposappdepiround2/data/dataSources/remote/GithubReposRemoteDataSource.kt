package com.example.githubreposappdepiround2.data.dataSources.remote

import android.util.Log
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api.GithubApi
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.api.RepoDetailsApi
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.GithubReposDataModel
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.repo_details.RepositoryDetailsDataModel
import com.example.githubreposappdepiround2.data.mapper.toCustomExceptionDomainModel
import javax.inject.Inject

class GithubReposRemoteDataSource @Inject constructor(
    private val githubApi: GithubApi,
    private val repoDetailsApi: RepoDetailsApi,
) {
    suspend fun fetchGithubRepos(): GithubReposDataModel {
        return try {
            githubApi.fetchGithubRepos().body() as GithubReposDataModel
        } catch (e: Exception) {
            Log.d("githubReposList", "exception in remoteDS: ${e.message}")
            throw e.toCustomExceptionDomainModel()
        }
    }

    suspend fun fetchGithubRepositoryDetails(
        owner: String,
        name: String,
    ): RepositoryDetailsDataModel {
        return try {
            repoDetailsApi.fetchRepoDetails(owner, name).body() as RepositoryDetailsDataModel
        } catch (e: Exception) {
            Log.d("fetchGithubRepositoryDetails", "exception in remoteDS: ${e.message}")
            throw e.toCustomExceptionDomainModel()
        }
    }
}