package com.example.githubreposappdepiround2.domain.usecase

import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel
import com.example.githubreposappdepiround2.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubRepoListUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {

   suspend operator fun invoke(): List<GithubRepoDomainModel> {
        return githubReposRepository.fetchGithubRepos()
    }
}
// fetchGithubRepoListUseCase.fetchGithubRepoList()
// fetchGithubRepoListUseCase()