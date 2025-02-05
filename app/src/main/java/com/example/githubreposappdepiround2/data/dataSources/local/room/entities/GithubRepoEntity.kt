package com.example.githubreposappdepiround2.data.dataSources.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.githubreposappdepiround2.data.Constants.Companion.GITHUB_REPOS_TABLE

@Entity(tableName = GITHUB_REPOS_TABLE)
data class GithubRepoEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val avatar: String,
    val description: String,
    val forks: Int,
    val language: String,
    val stars: Int,
    val url: String,
    val owner: String,
)
