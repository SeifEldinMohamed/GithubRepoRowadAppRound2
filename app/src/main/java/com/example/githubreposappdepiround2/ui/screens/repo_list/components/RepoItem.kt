package com.example.githubreposappdepiround2.ui.screens.repo_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubreposappdepiround2.R
import com.example.githubreposappdepiround2.ui.screens.repo_list.model.GithubRepoUiModel
import com.example.githubreposappdepiround2.ui.screens.repo_list.preview.fakeRepoList
import com.example.githubreposappdepiround2.ui.theme.GithubRepoAppDEPIRound2Theme
import com.example.githubreposappdepiround2.ui.theme.Yellow

@Composable
fun RepoItem(
    githubRepoUiModel: GithubRepoUiModel,
    modifier: Modifier = Modifier,
    onItemClick: (owner: String, name: String) -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .clickable {
                onItemClick(githubRepoUiModel.owner, githubRepoUiModel.name)
            }
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(shape = CircleShape),
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(githubRepoUiModel.avatar)
                    .crossfade(1000)
                    .build()
            ),
            contentDescription = null
        )

        Column(
            Modifier.padding(8.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = githubRepoUiModel.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = githubRepoUiModel.stars.toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp),
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Yellow)
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = githubRepoUiModel.owner,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = githubRepoUiModel.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFD0BCFF
)
@Composable
private fun PreviewRepoItem() {
    GithubRepoAppDEPIRound2Theme {
        RepoItem(githubRepoUiModel = fakeRepoList.first(), onItemClick = { _, _ -> })
    }
}