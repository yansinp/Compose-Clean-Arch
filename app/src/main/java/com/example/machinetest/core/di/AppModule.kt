package com.example.machinetest.core.di

import android.app.Application
import androidx.room.Room
import com.example.machinetest.data.local.RepoDao
import com.example.machinetest.data.local.RepoDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepoDataBase(application: Application) = Room.databaseBuilder(
        application, RepoDataBase::class.java,"repo_database"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideRepoDao(repoDataBase: RepoDataBase) : RepoDao{
        return repoDataBase.dao
    }

}