package com.example.githubreposappdepiround2.ui.navigation

sealed class Screens(val route: String) {
    data object RepoListScreen: Screens("repo_list")
    data object RepoDetailsScreen : Screens("repo_details/{owner}/{user_name}"){
        fun passOwnerAndName(owner: String, name:String): String {
            return "repo_details/$owner/$name"
        }
    }
}