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
class TrendingViewModel@Inject constructor (private val trendingUseCase: TrendingUseCase): ViewModel() {

    val trendingList: MutableState<List<TrendingDomainModel>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)

    init {
        getTrendingGithubList()
    }

    fun getTrendingGithubList(){
        viewModelScope.launch(Dispatchers.Main) {
            trendingUseCase.invoke().collect {
                when(it){
                    is Resource.Loading -> {
                        loading.value = true
                    }
                    is Resource.Success -> {
                        loading.value = false
                        it.data?.let{list -> trendingList.value = list}
                    }
                    is Resource.Error -> {
                        it.data?.let{list -> trendingList.value = list}
                        loading.value = false
                    }
                }
            }
        }
    }

//    fun onMenuSelect(index: Int){
//        when(index){
//            0 ->{
//                val list = restaurantList.value.sortedBy { it.distance }
//                restaurantList.value = list
//            }
//            1 ->{
//                val list = restaurantList.value.sortedBy { it.rating }
//                restaurantList.value = list
//            }
//        }
//    }

}