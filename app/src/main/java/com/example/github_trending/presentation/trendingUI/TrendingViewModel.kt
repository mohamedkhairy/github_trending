package com.example.github_trending.presentation.trendingUI

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.github_trending.domain.core.Resource
import com.example.github_trending.domain.entity.TrendingDomainModel
import com.example.github_trending.domain.useCases.TrendingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(private val trendingUseCase: TrendingUseCase) :
    ViewModel() {

    val trendingList: MutableState<List<TrendingDomainModel>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val isError: MutableState<Boolean> = mutableStateOf(false)

    init {
        getTrendingGithubList()
    }

/**
 * this method can emit 3 state to UI
 * Loading -> when the app trying to get data
 * Success -> when data return successfully
 * Error -> will return old data if it's available or Error if not
 * */
    fun getTrendingGithubList() {
        viewModelScope.launch(Dispatchers.Main) {
            trendingUseCase.invoke().collect {
                when (it) {
                    is Resource.Loading -> {
                        loading.value = true
                        isError.value = false
                    }
                    is Resource.Success -> {
                        loading.value = false
                        isError.value = false
                        it.data?.let { list -> trendingList.value = list }
                    }
                    is Resource.Error -> {
                        loading.value = false

                        if (!it.data.isNullOrEmpty()) {
                            trendingList.value = it.data
                            isError.value = false
                        } else
                            isError.value = true


                    }
                }
            }
        }
    }


}