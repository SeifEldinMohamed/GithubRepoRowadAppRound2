package com.example.githubreposappdepiround2.data.mapper

import com.example.githubreposappdepiround2.data.dataSources.local.room.entities.GithubRepoEntity
import com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model.Item

fun Item.toGithubRepoEntity(): GithubRepoEntity {
    return GithubRepoEntity(
        id = id,
        name = name,
        avatar = owner.avatar_url,
        description = description,
        forks = forks,
        language = language?: "Kotlin",
        stars = stargazers_count,
        url = url,
        owner = owner.login
    )
}