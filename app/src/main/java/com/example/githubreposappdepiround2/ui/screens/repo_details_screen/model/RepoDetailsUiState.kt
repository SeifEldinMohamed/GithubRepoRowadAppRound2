package com.example.githubreposappdepiround2.ui.screens.repo_details_screen.model

import com.example.githubreposappdepiround2.ui.model.CustomExceptionUiModel


//data class RepositoryDetailsUiState(
//    val repositoryDetails: RepositoryDetailsUiModel? = null,
//    val isLoading: Boolean = false,
//    val isError: Boolean = false,
//    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
//)

sealed class RepoDetailsUiState {
    data object InitialState: RepoDetailsUiState()
    data class RepoDetailsUiModelData(val repositoryDetails: RepoDetailsUiModel) : RepoDetailsUiState()
    data class Loading(val isLoading: Boolean = true) : RepoDetailsUiState()
     data class Error(val customErrorExceptionUiModel: CustomExceptionUiModel) : RepoDetailsUiState()
}