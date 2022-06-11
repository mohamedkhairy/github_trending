package com.example.github_trending.di

import com.example.github_trending.domain.repository.TrendingRepository
import com.example.github_trending.domain.useCases.TrendingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {



        @ViewModelScoped
        @Provides
        fun provideTrendingUseCase(trendingRepository : TrendingRepository) : TrendingUseCase {
            return TrendingUseCase(trendingRepository)
        }

}