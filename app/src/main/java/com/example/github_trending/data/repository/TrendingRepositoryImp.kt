package com.example.github_trending.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import com.example.github_trending.data.source.local.GithubTrendingDao
import com.example.github_trending.data.source.mapper.TrendingToDomainMapper
import com.example.github_trending.data.source.mapper.TrendingToEntityMapper
import com.example.github_trending.data.source.remote.service.TrendingGithubService
import com.example.github_trending.data.utils.networkBoundResource
import com.example.github_trending.domain.core.Resource
import com.example.github_trending.domain.entity.TrendingDomainModel
import com.example.github_trending.domain.repository.TrendingRepository
import javax.inject.Inject

class TrendingRepositoryImp @Inject constructor(val trendingGithubService: TrendingGithubService,
                                                val githubTrendingDao: GithubTrendingDao,
                                                val domainMapper: TrendingToDomainMapper,
                                                val entityMapper: TrendingToEntityMapper
) : TrendingRepository {

    override suspend fun getGithubTrending(): Flow<Resource<List<TrendingDomainModel>?>>  =  networkBoundResource(
        query = {
            githubTrendingDao.getAll().map { savedData ->

                domainMapper.toDomainList(savedData)
            }
        },
        fetch = {
            val response = trendingGithubService.callTrendingGithub()
            entityMapper.toEntityList(response)
        },
        saveFetchResult = { data ->
            githubTrendingDao.deleteAll()
            githubTrendingDao.save(data)
            domainMapper.toDomainList(data)
        }
    ).onStart {
        emit(Resource.Loading(null))
    }
        .flowOn(Dispatchers.IO)


}