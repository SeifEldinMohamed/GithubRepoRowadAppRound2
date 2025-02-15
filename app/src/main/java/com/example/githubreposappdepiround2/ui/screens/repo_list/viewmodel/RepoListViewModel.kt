package com.example.githubreposappdepiround2.ui.screens.repo_list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.githubreposappdepiround2.domain.usecase.FetchGithubRepoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val fetchGithubRepoListUseCase: FetchGithubRepoListUseCase
): ViewModel() {

    fun requestGithubRepoList() {
        val githubRepoListDomainModel = fetchGithubRepoListUseCase()
        //
    }
}