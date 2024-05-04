package com.example.machinetest.core.di

import com.example.machinetest.data.remote.RepoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkServiceModule {
    @Provides
    @Singleton
    fun provideImageService(retrofit: Retrofit): RepoApi {
        return retrofit.create(RepoApi::class.java)
    }

}