package com.example.githubreposappdepiround2.ui.mapper

import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel
import com.example.githubreposappdepiround2.ui.screens.repo_list.model.GithubRepoUiModel

fun GithubRepoDomainModel.toGithubRepoUiModel(): GithubRepoUiModel {
    return GithubRepoUiModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}