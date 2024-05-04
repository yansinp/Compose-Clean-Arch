package com.example.machinetest.data.remote

import com.example.machinetest.core.util.Constants
import com.example.machinetest.core.util.Resource
import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.data.remote.dto.RepoDetailsDto
import com.example.machinetest.domain.RepoRepository
import com.skydoves.sandwich.StatusCode
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query
import javax.inject.Inject


class RepoRepositoryImpl @Inject constructor(
    private val repoApi: RepoApi
) : RepoRepository {
    override fun getRepo(query: String): Flow<Resource<RepoDetailsDto>> = flow {
        emit(Resource.Loading)
        repoApi.getRepos(query, 1, 10)
            .suspendOnSuccess {
                val response = this.data
                if (response != null) {
                    emit(Resource.Success(response))
                } else {
                    emit(Resource.Error(Constants.GENERAL_ERROR_MESSAGE))
                }
            }
            .suspendOnError {
                try {

                    when (this.statusCode) {
                        StatusCode.InternalServerError -> emit(Resource.Error(Constants.SERVER_ERROR))
                        else -> {
                            emit(Resource.Error("Unable to fetch article details"))
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Error(Constants.GENERAL_ERROR_MESSAGE))
                }
            }
            .suspendOnException { emit(Resource.Error(Constants.NO_INTERNET_ERROR_MESSAGE)) }
    }

}