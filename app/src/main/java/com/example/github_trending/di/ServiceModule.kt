package com.example.github_trending.di

import com.example.github_trending.data.source.remote.service.TrendingGithubService
import com.example.github_trending.data.source.remote.service.TrendingGithubServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*

@Module
@InstallIn(ViewModelComponent::class)
object ServiceModule {

    @ViewModelScoped
    @Provides
    fun provideTrendingGithubService(httpClient: HttpClient): TrendingGithubService {
        return TrendingGithubServiceImpl(httpClient)
    }

}