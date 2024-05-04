package com.example.machinetest.presentation.repoDetails

import com.example.machinetest.data.remote.dto.RepoDetailsDto

data class RepoDetailsUiState(
    val repoDetails: RepoDetailsDto? = null,
    val error: String = "",
    val loading: Boolean = false
)