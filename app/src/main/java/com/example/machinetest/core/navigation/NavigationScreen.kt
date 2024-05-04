package com.example.machinetest.core.navigation

sealed class NavigationScreen(val route:String){
    object NavigationRepoScreen:NavigationScreen(route="RepoScreen")
    object NavigationRepoDetailsScreen:NavigationScreen(route="RepoDetailsScreen")
}
