package com.example.githubreposappdepiround2.domain.repository

import com.example.githubreposapp.domain.model.RepositoryDetailsDomainModel
import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel

interface GithubReposRepository {
    suspend fun fetchGithubRepos(): List<GithubRepoDomainModel>
    suspend fun fetchGithubRepositoryDetails(owner:String, name:String): RepositoryDetailsDomainModel
}