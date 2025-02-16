package com.example.githubreposapp.domain.model

data class RepositoryDetailsDomainModel(
    val id:Int,
    val name: String,
    val avatar: String,
    val description: String,
    val forks: Int,
    val language: String,
    val fullName: String,
    val stars: Int,
    val url: String,
    val owner: String,
    val createdAt: String
)