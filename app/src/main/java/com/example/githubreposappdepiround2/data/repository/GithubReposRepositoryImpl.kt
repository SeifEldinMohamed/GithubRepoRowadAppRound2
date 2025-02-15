package com.example.githubreposappdepiround2.data.repository

import com.example.githubreposappdepiround2.data.dataSources.local.GithubReposLocalDataSource
import com.example.githubreposappdepiround2.data.dataSources.remote.GithubReposRemoteDataSource
import com.example.githubreposappdepiround2.data.mapper.toGithubRepoDomainModel
import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel
import com.example.githubreposappdepiround2.domain.repository.GithubReposRepository
import javax.inject.Inject

class GithubReposRepositoryImpl @Inject constructor(
    private val githubReposRemoteDataSource: GithubReposRemoteDataSource,
    private val githubReposLocalDataSource: GithubReposLocalDataSource
): GithubReposRepository {
    override fun fetchGithubRepos(): List<GithubRepoDomainModel> {
        return githubReposRemoteDataSource.fetchGithubRepos().toGithubRepoDomainModel()
    }

}
// DataModel ( DataLayer)
// DomainModel (Domain Layer)
// UiModel ( UI Layer )