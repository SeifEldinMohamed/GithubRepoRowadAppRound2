package com.example.githubreposappdepiround2.ui.screens.repo_details_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubreposappdepiround2.domain.model.CustomExceptionDomainModel
import com.example.githubreposappdepiround2.domain.usecase.FetchRepoDetailsUseCase
import com.example.githubreposappdepiround2.ui.mapper.toCustomExceptionPresentationModel
import com.example.githubreposappdepiround2.ui.mapper.toRepositoryDetailsUIModel
import com.example.githubreposappdepiround2.ui.screens.repo_details_screen.model.RepoDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val fetchRepoDetailsUseCase: FetchRepoDetailsUseCase,
) : ViewModel() {
    private val _repoDetailsStateFlow: MutableStateFlow<RepoDetailsUiState> = MutableStateFlow(
        RepoDetailsUiState.InitialState
    )
    val repoDetailsStatFlow: StateFlow<RepoDetailsUiState> = _repoDetailsStateFlow.asStateFlow()

    fun requestGithubRepoList(
        owner: String,
        name: String,
    ) {
        _repoDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val repositoryDetailsDomainModel = fetchRepoDetailsUseCase(owner, name)
                _repoDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _repoDetailsStateFlow.value = RepoDetailsUiState.RepoDetailsUiModelData(
                    repositoryDetails = repositoryDetailsDomainModel.toRepositoryDetailsUIModel()
                )
            } catch (e: CustomExceptionDomainModel) {
                _repoDetailsStateFlow.value = RepoDetailsUiState.Loading(isLoading = false)
                _repoDetailsStateFlow.value =
                    RepoDetailsUiState.Error(customErrorExceptionUiModel = e.toCustomExceptionPresentationModel())
            }
        }
    }
}