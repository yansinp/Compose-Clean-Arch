package com.example.machinetest.presentation.repo

import com.example.machinetest.data.remote.dto.Item


data class RepoUiState(
    val repoDetails: List<Item>? = null,
    val error: String = "",
    val loading: Boolean = false
)
