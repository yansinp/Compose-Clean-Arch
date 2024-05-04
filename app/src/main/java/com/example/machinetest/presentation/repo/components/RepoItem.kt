package com.example.machinetest.presentation.repo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.machinetest.data.remote.dto.Item

@Composable
fun RepoItem(item: Item, onItemClick: (String) -> Unit) {
    Surface(
        modifier = Modifier
            .clickable { onItemClick.invoke(item.id.toString()) }
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .background(MaterialTheme.colors.onSurface)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.DarkGray)
            ) {
                AsyncImage(
                    model = item.owner?.avatarUrl,
                    contentDescription =
                    "",
                    modifier = Modifier
                        .statusBarsPadding()
                        .height(293.dp)
                        .fillMaxWidth()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .wrapContentHeight()
                    .weight(1f)
            ) {
                Text(
                    text = item.fullName ?: "",
                    modifier = Modifier.fillMaxSize(),
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = item.description ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    fontWeight = FontWeight.Normal,
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    color = Color.Gray,

                    )
            }
            Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "")

        }
    }
}