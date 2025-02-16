package com.example.githubreposappdepiround2.domain.usecase

import com.example.githubreposappdepiround2.data.repository.GithubReposRepositoryImpl
import com.example.githubreposappdepiround2.domain.model.CustomExceptionDomainModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FetchRepoDetailsUseCaseTest {
    // CUT
    private lateinit var fetchRepoDetailsUseCase: FetchRepoDetailsUseCase

    private lateinit var githubReposRepositoryImpl: GithubReposRepositoryImpl

    @Before
    fun setup() {
        githubReposRepositoryImpl = mockk()
        fetchRepoDetailsUseCase = FetchRepoDetailsUseCase(githubReposRepositoryImpl)
    }


    @Test
    fun `when invoke is called, then it should return repositoryDetailsDomainModel`() {
        runBlocking {
            // given (Arrange)
            val expected = fakeDetailsDomainModel
            coEvery { githubReposRepositoryImpl.fetchGithubRepoDetails(any(), any()) } returns expected

            // when (Act)
            val result = fetchRepoDetailsUseCase("seif", "name")

            // then (Assert)
            assertEquals(expected, result)
        }
    }

    @Test(expected = CustomExceptionDomainModel.NetworkExceptionDomainModel::class)
    fun `give repository throw an NetworkExceptionDomainModel, when invoke called,  then it should throw same exception`() {
        runBlocking {
            // given (Arrange)
            val expected = CustomExceptionDomainModel.NetworkExceptionDomainModel
            coEvery { githubReposRepositoryImpl.fetchGithubRepoDetails(any(), any()) } throws  expected

            // when (Act)
            fetchRepoDetailsUseCase("seif", "name")

        }
    }
}