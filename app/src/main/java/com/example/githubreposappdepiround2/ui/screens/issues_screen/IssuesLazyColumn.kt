package com.example.githubreposapp.presentation.screens.issues_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.githubreposappdepiround2.ui.screens.issues_screen.IssueItem
import com.example.githubreposappdepiround2.ui.screens.issues_screen.model.IssuesUiModel


@Composable
fun IssuesLazyColumn(
    issuesList: List<IssuesUiModel>,
) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(top = 4.dp)
            .padding(bottom = 2.dp)
    ) {
        itemsIndexed(items = issuesList){ index, issueUiModel ->
            IssueItem(
                issuesUiModel = issueUiModel,
            )
            HorizontalDivider()
        }
    }
}