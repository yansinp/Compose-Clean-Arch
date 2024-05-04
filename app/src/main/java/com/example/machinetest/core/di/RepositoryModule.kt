package com.example.machinetest.core.di

import com.example.machinetest.data.remote.RepoApi
import com.example.machinetest.data.remote.RepoRepositoryImpl
import com.example.machinetest.domain.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {
    @Provides
    @Singleton
    fun provideArticleRepository(
        repoApi: RepoApi
    ): RepoRepository {
        return RepoRepositoryImpl(repoApi)
    }
}