package com.example.githubreposappdepiround2.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.githubreposappdepiround2.data.Constants.Companion.DATABASE_NAME
import com.example.githubreposappdepiround2.data.dataSources.local.dataStore.DataStorePreference
import com.example.githubreposappdepiround2.data.dataSources.local.room.GithubReposDatabase
import com.example.githubreposappdepiround2.data.dataSources.local.room.dao.GithubReposDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomInstance(
        @ApplicationContext context: Context,
    ): GithubReposDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = GithubReposDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideGithubRepoDao(
        githubReposDatabase: GithubReposDatabase,
    ): GithubReposDao {
        return githubReposDatabase.getGithubReposDao()
    }

    @Provides
    @Singleton
    fun provideStatStorePreference(
        @ApplicationContext context: Context
    ): DataStorePreference {
        return DataStorePreference(context)
    }

}