package com.example.githubreposappdepiround2.data.dataSources.local

import com.example.githubreposappdepiround2.data.dataSources.local.room.dao.GithubReposDao
import com.example.githubreposappdepiround2.data.dataSources.local.room.entities.GithubRepoEntity
import com.example.githubreposappdepiround2.di.DatabaseModule

class GithubReposLocalDataSource(
   private val githubReposDao: GithubReposDao
//  DatabaseModule.provideGithubRepoDao(
//        DatabaseModule.provideRoomInstance()
//    )
) {
    fun insertGithubRepoList(githubRepoEntityList: List<GithubRepoEntity>){
        githubReposDao.insertGithubRepoList(githubRepoEntityList)
    }

    fun getGithubRepoList(): List<GithubRepoEntity>{
        return githubReposDao.getGithubRepoList()
    }
}