package com.example.githubreposappdepiround2.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.githubreposappdepiround2.data.Constants.Companion.DATABASE_NAME
import com.example.githubreposappdepiround2.data.dataSources.local.room.GithubReposDatabase
import com.example.githubreposappdepiround2.data.dataSources.local.room.dao.GithubReposDao

class DatabaseModule {
    companion object {
        fun provideRoomInstance(
            context: Context,
        ): GithubReposDatabase {
            return Room.databaseBuilder(
                context = context,
                klass = GithubReposDatabase::class.java,
                name = DATABASE_NAME
            ).build()
        }

        fun provideGithubRepoDao(
            githubReposDatabase: GithubReposDatabase
        ): GithubReposDao {
            return githubReposDatabase.getGithubReposDao()
        }
    }

}