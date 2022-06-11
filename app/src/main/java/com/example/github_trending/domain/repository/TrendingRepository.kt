package com.example.github_trending.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.github_trending.domain.core.Resource
import com.example.github_trending.domain.entity.TrendingDomainModel

interface TrendingRepository {

    suspend fun getGithubTrending(): Flow<Resource<List<TrendingDomainModel>?>>

}