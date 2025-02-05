package com.example.githubreposappdepiround2.data

class Constants {
    companion object {
        const val BASE_URL = "https://api.github.com/"
        const val GITHUB_REPOS_ENDPOINT = "search/repositories?q=language"
        const val DATABASE_NAME = "github_repos_database"

        // room
        const val GITHUB_REPOS_TABLE = "github_repos_table"

        // data store
        const val PREFERENCES_NAME = "github_preference"
        const val PREFERENCES_IS_FIRST_TIME = "is_first_time"

        // keys
        const val OWNER_KEY = "owner"
        const val REPO_NAME_KEY = "repo"

    }
}