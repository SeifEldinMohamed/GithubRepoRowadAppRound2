package com.example.githubreposappdepiround2.data.dataSources.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubreposappdepiround2.data.dataSources.local.room.dao.GithubReposDao
import com.example.githubreposappdepiround2.data.dataSources.local.room.entities.GithubRepoEntity

@Database(
    entities = [GithubRepoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubReposDatabase: RoomDatabase() {
    abstract fun getGithubReposDao(): GithubReposDao
}