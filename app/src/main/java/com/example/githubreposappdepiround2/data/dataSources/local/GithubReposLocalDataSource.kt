package com.example.githubreposappdepiround2.data.dataSources.local

import com.example.githubreposappdepiround2.data.dataSources.local.room.dao.GithubReposDao
import com.example.githubreposappdepiround2.data.dataSources.local.room.entities.GithubRepoEntity
import javax.inject.Inject

class GithubReposLocalDataSource @Inject constructor(
   private val githubReposDao: GithubReposDao
) {
    fun insertGithubRepoList(githubRepoEntityList: List<GithubRepoEntity>){
        githubReposDao.insertGithubRepoList(githubRepoEntityList)
    }

    fun getGithubRepoList(): List<GithubRepoEntity>{
        return githubReposDao.getGithubRepoList()
    }
}