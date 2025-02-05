package com.example.githubreposappdepiround2.data.dataSources.remote.retrofit.model

import com.google.gson.annotations.SerializedName

data class GithubReposDataModel(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>,
    val total_count: Int
)