package com.example.machinetest.presentation.repo

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.machinetest.core.util.Resource
import com.example.machinetest.data.remote.RepoRepositoryImpl
import com.example.machinetest.domain.RepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor(private val repoRepository: RepoRepositoryImpl) : ViewModel() {

    var repoState = mutableStateOf(RepoUiState())
        private set

    init {
        getRepo("Android")
        // internet check
    }

     fun getRepo(query :String) = viewModelScope.launch {
        repoRepository.getRepo(query).collectLatest { repoDetails ->

            when(repoDetails){
                Resource.Empty -> {

                }
                is Resource.Error -> {
                    repoState.value = repoState.value.copy(error = repoDetails.error , loading = false)
                }
                Resource.Loading -> {
                    repoState.value = repoState.value.copy(loading = true)
                }
                is Resource.Success -> {
                    repoState.value = repoState.value.copy(error = "" , loading = false, repoDetails = repoDetails.value)
                }
            }

        }
    }


}