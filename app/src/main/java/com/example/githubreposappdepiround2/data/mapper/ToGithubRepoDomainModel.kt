package com.example.githubreposappdepiround2.data.mapper

import com.example.githubreposappdepiround2.data.dataSources.local.room.entities.GithubRepoEntity
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.GithubReposDataModel
import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel

fun GithubRepoEntity.toGithubRepoDomainModel(): GithubRepoDomainModel {
    return GithubRepoDomainModel(
        id = this.id,
        name = this.name,
        avatar = this.avatar,
        description = this.description,
        stars = this.stars,
        owner = this.owner
    )
}