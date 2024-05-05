package com.example.machinetest.domain

import com.example.machinetest.core.util.Resource
import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.data.remote.dto.RepoDetailsDto
import kotlinx.coroutines.flow.Flow


interface RepoRepository {

    fun getRepo(
        query: String,
        page: Int,
        perPage: Int,
        isNetworkAvailable: Boolean
    ): Flow<Resource<List<Item>>>
}