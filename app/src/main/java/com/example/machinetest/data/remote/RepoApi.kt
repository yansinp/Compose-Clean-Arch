package com.example.machinetest.data.remote

import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.data.remote.dto.RepoDetailsDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoApi {
    @GET("search/repositories")
    suspend fun getRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): ApiResponse<RepoDetailsDto>
}