package com.example.machinetest.presentation.repo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.presentation.repo.components.RepoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoItemScreen(repoUiState: RepoUiState, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Search Image",
                    color = Color.Gray,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 5.dp),
                    textAlign = TextAlign.Center
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(24.dp),
                    tint = Color.Gray
                )
            },
            actions = {
                Row(modifier = Modifier.wrapContentSize()) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp),
                        tint = Color.Gray
                    )
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(24.dp),
                        tint = Color.Gray
                    )

                }
            }
        )
        if (repoUiState.loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        } else LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(repoUiState.repoDetails?.items ?: emptyList()) { item ->
                if (item != null) {
                    RepoItem(item)
                    { singleItem ->
                        onItemClick.invoke(singleItem)
                    }
                }
            }
        }
    }
}