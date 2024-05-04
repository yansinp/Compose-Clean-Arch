package com.example.machinetest.presentation.repo

import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.data.remote.dto.RepoDetailsDto


data class RepoUiState(
    val repoDetails: RepoDetailsDto? = null,
    val error: String = "",
    val loading: Boolean = false
)
