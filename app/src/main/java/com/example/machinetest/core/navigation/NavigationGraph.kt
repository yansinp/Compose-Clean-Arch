package com.example.machinetest.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.machinetest.presentation.repo.RepoItemScreen
import com.example.machinetest.presentation.repo.RepoViewModel
import com.example.machinetest.presentation.repoDetails.RepoDetailsScreen


@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationScreen.NavigationRepoScreen.route,
        modifier = Modifier
    ) {
        composable(NavigationScreen.NavigationRepoScreen.route) {
            val viewModel: RepoViewModel = hiltViewModel()
            val repoUiState = viewModel.repoState.value
            RepoItemScreen(repoUiState) { singleId ->
                navController.navigate(NavigationScreen.NavigationRepoDetailsScreen.route + "/$singleId")
            }
        }

        composable(NavigationScreen.NavigationRepoDetailsScreen.route + "/{singleId}") {
            val viewModel: RepoViewModel = hiltViewModel()
            val repoUiState = viewModel.repoState.value
            RepoDetailsScreen(navController,viewModel,repoUiState)
        }

    }
}