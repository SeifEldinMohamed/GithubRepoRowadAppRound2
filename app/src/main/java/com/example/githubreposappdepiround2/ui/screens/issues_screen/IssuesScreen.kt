package com.example.githubreposappdepiround2.ui.screens.issues_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.githubreposapp.presentation.screens.issues_screen.IssuesLazyColumn
import com.example.githubreposappdepiround2.ui.screens.issues_screen.model.IssuesUiModel
import com.example.githubreposapp.presentation.screens.issues_screen.preview.issuesUiModelPreviewData
import com.example.githubreposappdepiround2.R
import com.example.githubreposappdepiround2.ui.common_components.AppBar
import com.example.githubreposappdepiround2.ui.common_components.ErrorSection
import com.example.githubreposappdepiround2.ui.common_components.shimmer.issues.AnimateShimmerIssuesList
import com.example.githubreposappdepiround2.ui.theme.GithubRepoAppDEPIRound2Theme
import com.example.githubreposappdepiround2.ui.theme.LightGreen


@ExperimentalMaterial3Api
@Composable
fun IssuesScreen(
    issuesUiState: IssuesUiState,
    onRefreshList: () -> Unit,
    onBackArrowClicked: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.background)) {
        AppBar(
            title = R.string.issues_app_bar_title,
            onBackButtonClicked = { onBackArrowClicked() }
        )
        when {
            issuesUiState.isLoading -> {
                AnimateShimmerIssuesList()
            }
            issuesUiState.issuesList != null -> {
                val isRefreshing by remember { // in viewmodel and before calling api make on refreshing = true then after getting data from api make onrefreshing = false
                    mutableStateOf(false)
                }
                IssuesContent(issuesUiState.issuesList,isRefreshing = isRefreshing, onPulledToRefresh = onRefreshList)
            }
            else ->{
                ErrorSection(
                    onRefreshButtonClicked = onRefreshList,
                    customErrorExceptionUiModel = issuesUiState.customErrorExceptionUiModel
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun IssuesContent(
    issuesList: List<IssuesUiModel>,
    isRefreshing:Boolean,
    onPulledToRefresh: () -> Unit
) {
    val pullToRefreshState = rememberPullToRefreshState()
    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(pullToRefreshState.nestedScrollConnection)
    ) {
        IssuesLazyColumn(
            issuesList = issuesList
        )

        if (pullToRefreshState.isRefreshing){
            LaunchedEffect(key1 = true) {
                onPulledToRefresh()
            }
        }

        LaunchedEffect(key1 = isRefreshing) {
            if (isRefreshing)
                pullToRefreshState.startRefresh()
            else
                pullToRefreshState.endRefresh()
        }

        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = LightGreen
        )
    }

}

@ExperimentalMaterial3Api
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTrendingGithubScreen() {
    GithubRepoAppDEPIRound2Theme (darkTheme = false) {
        IssuesScreen(
            issuesUiState = IssuesUiState(
                issuesList  = listOf(issuesUiModelPreviewData)
            ),
            onRefreshList = {},
            onBackArrowClicked = {}
        )
    }
}