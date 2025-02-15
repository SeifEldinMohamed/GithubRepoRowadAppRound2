package com.example.githubreposappdepiround2.ui.screens.repo_list.preview

import com.example.githubreposappdepiround2.ui.model.CustomExceptionUiModel
import com.example.githubreposappdepiround2.ui.screens.repo_list.RepoListScreenUiState
import com.example.githubreposappdepiround2.ui.screens.repo_list.model.GithubRepoUiModel
import kotlin.math.truncate

val fakeRepoList = listOf<GithubRepoUiModel>(
    GithubRepoUiModel(
        id = 1,
        name = "Github Repo App",
        owner = "Seif",
        avatar = "",
        stars = 2000,
        description = "this repo related to Github Repo App which is built uisng kotlin and latest android technologies."
    ),
    GithubRepoUiModel(
        id = 2,
        name = "Kotlin",
        owner = "JetBrains",
        avatar = "",
        stars = 150000,
        description = "this repo related to Github Repo App which is built uisng kotlin and latest android technologies."
    ),
    GithubRepoUiModel(
        id = 3,
        name = "Github Repo App",
        owner = "Seif",
        avatar = "",
        stars = 2000,
        description = "this repo related to Github Repo App which is built uisng kotlin and latest android technologies."
    )
)

val fakeRepoListScreenUiState = RepoListScreenUiState(isLoading = true)
val fakeRepoListScreenUiStateError = RepoListScreenUiState(
    isError = true,
    customErrorExceptionUiModel = CustomExceptionUiModel.NoInternetConnection
)