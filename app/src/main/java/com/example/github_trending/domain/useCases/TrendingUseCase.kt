package com.example.github_trending.domain.useCases


import kotlinx.coroutines.flow.Flow
import com.example.github_trending.domain.core.Resource
import com.example.github_trending.domain.entity.TrendingDomainModel
import com.example.github_trending.domain.repository.TrendingRepository
import javax.inject.Inject

class TrendingUseCase @Inject constructor(
    private val trendingRepository: TrendingRepository
) {

    suspend fun invoke(): Flow<Resource<List<TrendingDomainModel>?>> =
        trendingRepository.getGithubTrending()
}
