package com.example.githubreposappdepiround2.domain.usecase

import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel
import com.example.githubreposappdepiround2.domain.repository.GithubReposRepository

class FetchGithubRepoListUseCase(
    private val githubReposRepository: GithubReposRepository
) {

   operator fun invoke(): List<GithubRepoDomainModel> {
        return githubReposRepository.fetchGithubRepos()
    }
}
// fetchGithubRepoListUseCase.fetchGithubRepoList()
// fetchGithubRepoListUseCase()