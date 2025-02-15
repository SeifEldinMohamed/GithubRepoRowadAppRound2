package com.example.githubreposappdepiround2.ui.screens.repo_list.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubreposappdepiround2.domain.model.CustomExceptionDomainModel
import com.example.githubreposappdepiround2.domain.usecase.FetchGithubRepoListUseCase
import com.example.githubreposappdepiround2.ui.mapper.toCustomExceptionPresentationModel
import com.example.githubreposappdepiround2.ui.mapper.toGithubRepoUiModel
import com.example.githubreposappdepiround2.ui.screens.repo_list.RepoListScreenUiState
import com.example.githubreposappdepiround2.ui.screens.repo_list.model.GithubRepoUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val fetchGithubRepoListUseCase: FetchGithubRepoListUseCase,
) : ViewModel() {
    private val _repoListStateFlow: MutableStateFlow<RepoListScreenUiState> = MutableStateFlow(
        RepoListScreenUiState()
    )
    val repoListStateFlow: StateFlow<RepoListScreenUiState> = _repoListStateFlow.asStateFlow()

    fun requestGithubRepoList() {
        _repoListStateFlow.value = RepoListScreenUiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val githubRepoListDomainModel = fetchGithubRepoListUseCase()
                _repoListStateFlow.value = RepoListScreenUiState(
                    githubRepoListUiModel = githubRepoListDomainModel.map { it.toGithubRepoUiModel() }
                )
            } catch (e: CustomExceptionDomainModel) {
                _repoListStateFlow.value = RepoListScreenUiState(
                    isError = true,
                    customErrorExceptionUiModel = e.toCustomExceptionPresentationModel()
                )
            } catch (e:Exception) {
                Log.d("ViewModel", e.message.toString())
            }
        }
    }
}