package com.example.githubreposappdepiround2.ui.screens.repo_list

data class GithubRepoUiModel(
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val owner: String,
    val stars: Int
)
