package com.example.machinetest.presentation.repo

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.machinetest.presentation.repo.components.RepoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoItemScreen(
    repoUiState: RepoUiState,
    onItemClick: (String) -> Unit,
) {

    val repoViewModel = viewModel<RepoViewModel>()
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var page by remember { mutableIntStateOf(1) }
    var perPage by remember { mutableIntStateOf(20) }
    val lazyListState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        CenterAlignedTopAppBar(

            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 5.dp)

                ) {

                    SearchBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),

                        query = text,
                        onQueryChange = {
                            text = it
                        },
                        onSearch = {
                            active = false
                            if (text.isNotEmpty()) {
                                repoViewModel.getRepo(text, page, perPage)
                            }
                        },
                        active = active,
                        onActiveChange = {
                            active = it
                        },
                        placeholder = {
                            Text(text = "Search Here")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon"
                            )
                        },
                        trailingIcon = {
                            if (active) {
                                Icon(
                                    modifier = Modifier.clickable {
                                        if (text.isNotEmpty()) {
                                            text = ""
                                        } else {
                                            active = false
                                        }

                                    },
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Close Icon"
                                )
                            }
                        }

                    ) {

                    }


                }
            })
        if (repoUiState.loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        } else LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            state = lazyListState
        ) {
            items(repoUiState.repoDetails ?: emptyList()) { item ->
                RepoItem(item) { singleItem ->
                    onItemClick.invoke(singleItem)
                }
            }
        }
//        LaunchedEffect(lazyListState) {
//            snapshotFlow { lazyListState.firstVisibleItemIndex }
//                .collect { firstVisibleItemIndex ->
//                    if (firstVisibleItemIndex >= (repoUiState.repoDetails?.size?.minus(1) ?: 0)) {
//                        // Reached the last item, load more data
//                        if ((repoUiState.repoDetails?.size ?: 0) < 100) {
//                            // Load more items on the same page
//                            repoViewModel.getRepo(text, page, perPage)
//                        } else {
//                            // Load next page
//                            page++
//                            repoViewModel.getRepo(text, page, perPage)
//                        }
//                    }
//                }
//        }

    }
}