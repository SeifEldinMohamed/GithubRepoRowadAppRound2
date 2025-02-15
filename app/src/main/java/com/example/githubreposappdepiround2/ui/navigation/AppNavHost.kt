package com.example.githubreposappdepiround2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubreposappdepiround2.ui.screens.repo_details_screen.RepoDetailsScreen
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
                onItemClick = { owner, name ->
                    navController.navigate(Screens.RepoDetailsScreen.passOwnerAndName(owner, name))
                }
            )
        }

        composable(route = Screens.RepoDetailsScreen.route) { navBackStackEntry ->
            val userName = navBackStackEntry.arguments?.getString("user_name")
            val owner = navBackStackEntry.arguments?.getString("owner")
            userName?.let {
                owner?.let {
                    RepoDetailsScreen(
                        owner = owner,
                        name = userName,
                        onClickViewIssues = {},
                        onShowIssuesClicked = {},
                        onClickBack = {}
                    )
                }
            }
        }
    }
}