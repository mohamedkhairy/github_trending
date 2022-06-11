package com.example.github_trending.di


import com.example.github_trending.data.repository.TrendingRepositoryImp
import com.example.github_trending.data.source.local.GithubTrendingDao
import com.example.github_trending.data.source.mapper.TrendingToDomainMapper
import com.example.github_trending.data.source.mapper.TrendingToEntityMapper
import com.example.github_trending.data.source.remote.service.TrendingGithubService
import com.example.github_trending.domain.repository.TrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object GithubModule {

    @ViewModelScoped
    @Provides
    fun provideTrendingRepository(trendingGithubService: TrendingGithubService,
                                  githubTrendingDao: GithubTrendingDao,
                                  domainMapper: TrendingToDomainMapper,
                                  entityMapper: TrendingToEntityMapper) : TrendingRepository {
        return TrendingRepositoryImp(trendingGithubService, githubTrendingDao, domainMapper, entityMapper)
    }



}