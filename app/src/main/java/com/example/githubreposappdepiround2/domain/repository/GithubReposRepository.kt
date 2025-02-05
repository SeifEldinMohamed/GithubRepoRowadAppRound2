package com.example.githubreposappdepiround2.domain.repository

import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel

interface GithubReposRepository {
    fun fetchGithubRepos(): List<GithubRepoDomainModel>
}