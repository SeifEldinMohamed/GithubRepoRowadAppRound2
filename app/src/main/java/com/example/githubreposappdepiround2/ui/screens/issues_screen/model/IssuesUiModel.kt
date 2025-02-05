package com.example.githubreposappdepiround2.ui.screens.issues_screen.model

import com.example.githubreposappdepiround2.ui.model.IssueState


data class IssuesUiModel(
    val id:Int,
    val title: String,
    val author: String,
    val date: String,
    val state: IssueState,
)