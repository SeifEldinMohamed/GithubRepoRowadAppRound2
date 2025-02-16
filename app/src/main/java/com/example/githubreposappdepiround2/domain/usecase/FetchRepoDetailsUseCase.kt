package com.example.githubreposappdepiround2.domain.usecase

import com.example.githubreposapp.domain.model.RepositoryDetailsDomainModel
import com.example.githubreposappdepiround2.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchRepoDetailsUseCase @Inject constructor(
    private val githubRepository: GithubReposRepository
) {
    suspend operator fun invoke(
        owner: String,
        name:String
    ) : RepositoryDetailsDomainModel {
        return githubRepository.fetchGithubRepositoryDetails(owner, name)
    }
}