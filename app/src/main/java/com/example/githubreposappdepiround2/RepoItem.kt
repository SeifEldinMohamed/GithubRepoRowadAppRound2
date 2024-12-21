package com.example.githubreposappdepiround2

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubreposappdepiround2.ui.theme.GithubRepoAppDEPIRound2Theme

@Composable
fun RepoItem(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
            }
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(shape = CircleShape),
            painter = painterResource(R.drawable.ic_launcher_background),
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
                    text = stringResource(R.string.reponame_placeholder),
                )
                Text(
                    modifier = Modifier.padding(end = 8.dp),
                    text = stringResource(R.string.stars_count_placeholder),
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = null,
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.repoowner_placeholder),
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.repo_description_placeholder),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
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
        RepoItem()
    }
}