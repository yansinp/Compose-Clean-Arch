package com.example.machinetest.presentation.repoDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.presentation.repo.RepoUiState
import com.example.machinetest.presentation.repo.RepoViewModel

@Composable
fun RepoDetailsScreen(
    navController: NavController,
    repoViewModel: RepoViewModel,
    repoUiState: RepoUiState
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val arguments = navBackStackEntry?.arguments
    val item  = arguments?.getString("singleId")

    Surface(modifier = Modifier.fillMaxSize()) {
        if (repoUiState.loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        } else {
            if (repoUiState.repoDetails == null) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Details Not found")
                }
            } else {

                val singleItem = repoUiState.repoDetails.filter { it.id.toString() == item }

                if (singleItem.isNotEmpty()){
                    DetailsScreenData(item = singleItem[0])
                }
            }
        }
    }

}

@Composable
fun DetailsScreenData(item: Item?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = item?.owner?.avatarUrl,
            contentDescription =
            "Article Image",
            modifier = Modifier
                .statusBarsPadding()
                .height(293.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = ("Author : " + item?.fullName),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Light,
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp
            )

            Text(
                text = ("Description : " + item?.description),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp
            )

            Row(modifier = Modifier.wrapContentSize()) {

                Text(
                    text = ("Git Url : " + item?.downloadsUrl),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 4.dp),
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

        }
    }
}

