package com.example.githubreposappdepiround2.data.mapper

import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.GithubReposDataModel
import com.example.githubreposappdepiround2.domain.model.GithubRepoDomainModel

fun GithubReposDataModel.toGithubRepoDomainModel(): List<GithubRepoDomainModel> {
    return this.items.map { item ->
        GithubRepoDomainModel(
            id = item.id,
            name = item.name,
            avatar = item.owner.avatar_url,
            description = item.description,
            stars = item.stargazers_count,
            owner = item.owner.login
        )
    }
}