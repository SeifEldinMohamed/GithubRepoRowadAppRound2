package com.example.githubreposappdepiround2.di


import com.example.githubreposappdepiround2.data.repository.GithubReposRepositoryImpl
import com.example.githubreposappdepiround2.domain.repository.GithubReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModuleWithBinds{
    @Binds
    @Singleton
    abstract fun provideGithubRepositoryImpl(
        githubReposRepositoryImpl: GithubReposRepositoryImpl
    ): GithubReposRepository

}

//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//
//    @Provides
//    @Singleton
//    fun provideGithubRepository(
//        githubReposRemoteDataSource: GithubReposRemoteDataSource,
//        githubReposLocalDataSource: GithubReposLocalDataSource
//    ):GithubReposRepository {
//        return GithubReposRepositoryImpl(githubReposRemoteDataSource, githubReposLocalDataSource)
//    }
//}
