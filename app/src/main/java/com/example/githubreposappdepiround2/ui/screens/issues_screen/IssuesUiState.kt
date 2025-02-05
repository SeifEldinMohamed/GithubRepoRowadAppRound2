package com.example.githubreposappdepiround2.ui.screens.issues_screen

import com.example.githubreposappdepiround2.ui.model.CustomExceptionUiModel
import com.example.githubreposappdepiround2.ui.screens.issues_screen.model.IssuesUiModel


data class IssuesUiState(
    val issuesList: List<IssuesUiModel>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
)