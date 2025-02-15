package com.example.githubreposappdepiround2.data.repository

import com.example.githubreposapp.domain.model.RepositoryDetailsDomainModel
import com.example.githubreposappdepiround2.data.dataSources.local.GithubReposLocalDataSource
import com.example.githubreposappdepiround2.data.dataSources.remote.GithubReposRemoteDataSource
import com.example.githubreposappdepiround2.data.mapper.toGithubRepoDomainModel
import com.example.githubreposappdepiround2.data.mapper.toGithubRepoEntity
import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel
import com.example.githubreposappdepiround2.domain.repository.GithubReposRepository
import javax.inject.Inject

class GithubReposRepositoryImpl @Inject constructor(
    private val githubReposRemoteDataSource: GithubReposRemoteDataSource,
    private val githubReposLocalDataSource: GithubReposLocalDataSource,
) : GithubReposRepository {
    override suspend fun fetchGithubRepos(): List<GithubRepoDomainModel> {
        // check if user first time to enter app
        return if (githubReposLocalDataSource.readIsFirstTimeEnterApp()) {
            // first time:
            // get data from api
            val githubReposDataModel = githubReposRemoteDataSource.fetchGithubRepos()
            // then cache in ROOM
            githubReposLocalDataSource.insertGithubRepoList(githubReposDataModel.items.map { it.toGithubRepoEntity() })
            // then return cached data
            githubReposLocalDataSource.getGithubRepoList().map { it.toGithubRepoDomainModel() }
        } else {
            // not first time
            // return cached data
            githubReposLocalDataSource.getGithubRepoList().map { it.toGithubRepoDomainModel() }
        }
    }

    override suspend fun fetchGithubRepositoryDetails(
        owner: String,
        name: String,
    ): RepositoryDetailsDomainModel {
        return githubReposRemoteDataSource.fetchGithubRepositoryDetails(owner, name).toGithubRepoDomainModel()
    }
}
// DataModel ( DataLayer)
// DomainModel (Domain Layer)
// UiModel ( UI Layer )