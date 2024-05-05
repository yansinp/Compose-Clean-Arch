package com.example.machinetest.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {

    @Upsert
    suspend fun upsertAll(repos: List<RepoEntity>)

    @Query("SELECT * FROM repoentity")
    fun selectAll(): Flow<List<RepoEntity>>
}