package com.example.githubreposappdepiround2.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubreposappdepiround2.ui.screens.repo_list.RepoItem
import com.example.githubreposappdepiround2.ui.screens.repo_list.RepoListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.RepoListScreen.route
    ) {
        composable(route = Screens.RepoListScreen.route) {
            RepoListScreen(
                onItemClick = {
                    navController.navigate(Screens.RepoDetailsScreen.passName(name = "Seif"))
                }
            )
        }

        composable(route = Screens.RepoDetailsScreen.route) { navBackStackEntry ->
            val userName = navBackStackEntry.arguments?.getString("user_name")
            userName?.let {
                Text(text = it)
            }
        }
    }
}