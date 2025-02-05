package com.example.githubreposappdepiround2.ui.screens.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.githubreposappdepiround2.ui.screens.repo_list.components.RepoItem
import com.example.githubreposappdepiround2.ui.screens.repo_list.preview.fakeRepoList
import com.example.githubreposappdepiround2.ui.screens.repo_list.viewmodel.RepoListViewModel
import com.example.githubreposappdepiround2.ui.theme.GithubRepoAppDEPIRound2Theme

@Composable
fun RepoListScreen(
    onItemClick: () -> Unit
) {
    val repoListViewModel: RepoListViewModel = viewModel()
    LaunchedEffect(Unit) {
        repoListViewModel.requestGithubRepoList()
    }
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(fakeRepoList) { repoItem ->
            RepoItem(
                githubRepoUiModel = repoItem,
                onItemClick = onItemClick
            )
        }
    }

}

@Preview
@Composable
private fun PreviewRepoScreen() {
    GithubRepoAppDEPIRound2Theme {
        // todo preview will not work
        RepoListScreen {

        }
    }
}