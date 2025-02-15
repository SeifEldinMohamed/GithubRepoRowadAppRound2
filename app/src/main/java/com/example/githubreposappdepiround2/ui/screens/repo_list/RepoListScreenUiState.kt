package com.example.githubreposappdepiround2.ui.screens.repo_list

import com.example.githubreposappdepiround2.ui.model.CustomExceptionUiModel
import com.example.githubreposappdepiround2.ui.screens.repo_list.model.GithubRepoUiModel

data class RepoListScreenUiState(
    val isLoading: Boolean = false,
    val isError:Boolean = false,
    val customErrorExceptionUiModel:CustomExceptionUiModel? = null,
    val githubRepoListUiModel: List<GithubRepoUiModel> = emptyList()
)
