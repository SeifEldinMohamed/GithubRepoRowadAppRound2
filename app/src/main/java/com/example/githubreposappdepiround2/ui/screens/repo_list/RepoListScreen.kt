package com.example.githubreposappdepiround2.ui.screens.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.githubreposappdepiround2.ui.screens.repo_list.preview.fakeRepoList

@Composable
fun RepoListScreen(
    onItemClick: () -> Unit
) {
    LazyColumn(
        Modifier.fillMaxSize()
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