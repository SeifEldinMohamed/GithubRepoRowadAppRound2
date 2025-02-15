package com.example.githubreposappdepiround2.ui.screens.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubreposappdepiround2.ui.common_components.ErrorSection
import com.example.githubreposappdepiround2.ui.common_components.shimmer.trending.AnimateShimmerTrendingList
import com.example.githubreposappdepiround2.ui.screens.repo_list.components.RepoItem
import com.example.githubreposappdepiround2.ui.screens.repo_list.preview.fakeRepoList
import com.example.githubreposappdepiround2.ui.screens.repo_list.preview.fakeRepoListScreenUiState
import com.example.githubreposappdepiround2.ui.screens.repo_list.preview.fakeRepoListScreenUiStateError
import com.example.githubreposappdepiround2.ui.screens.repo_list.viewmodel.RepoListViewModel
import com.example.githubreposappdepiround2.ui.theme.GithubRepoAppDEPIRound2Theme

@Composable
fun RepoListScreen(
    onItemClick: (owner: String, name: String) -> Unit,
) {
    val repoListViewModel: RepoListViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        repoListViewModel.requestGithubRepoList()
    }
    val repoListScreenUiState by repoListViewModel.repoListStateFlow.collectAsStateWithLifecycle()

    RepoListContent(
        repoListScreenUiState = repoListScreenUiState,
        onRefreshButtonClicked = {
            repoListViewModel.requestGithubRepoList()
        },
        onItemClick = onItemClick
    )


}

@Composable
fun RepoListContent(
    repoListScreenUiState: RepoListScreenUiState,
    onRefreshButtonClicked: () -> Unit,
    onItemClick: (owner: String, name: String) -> Unit,
) {
    when {
        repoListScreenUiState.isLoading -> {
            AnimateShimmerTrendingList()
        }

        repoListScreenUiState.isError -> {
            repoListScreenUiState.customErrorExceptionUiModel?.let {
                ErrorSection(
                    customErrorExceptionUiModel = it,
                    onRefreshButtonClicked = {
                        onRefreshButtonClicked()
                    }
                )
            }
        }

        repoListScreenUiState.githubRepoListUiModel.isNotEmpty() -> {
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                items(repoListScreenUiState.githubRepoListUiModel) { repoItem ->
                    RepoItem(
                        githubRepoUiModel = repoItem,
                        onItemClick = onItemClick
                    )
                }
            }
        }

        else -> {}
    }
}

@Preview
@Composable
private fun PreviewRepoContentLoading() {
    GithubRepoAppDEPIRound2Theme {
        RepoListContent(
            repoListScreenUiState = fakeRepoListScreenUiState,
            onRefreshButtonClicked = {},
            onItemClick = { _, _ -> }
        )
    }
}

@Preview
@Composable
private fun PreviewRepoContentError() {
    GithubRepoAppDEPIRound2Theme {
        RepoListContent(
            repoListScreenUiState = fakeRepoListScreenUiStateError,
            onRefreshButtonClicked = {},
            onItemClick = { _, _ -> }
        )
    }
}