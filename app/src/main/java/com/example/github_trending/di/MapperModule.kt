package com.example.github_trending.di

import com.example.github_trending.data.source.mapper.TrendingToDomainMapper
import com.example.github_trending.data.source.mapper.TrendingToEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideEntityMapper(): TrendingToEntityMapper {
        return TrendingToEntityMapper()
    }

    @Singleton
    @Provides
    fun provideDomainMapper (): TrendingToDomainMapper {
        return TrendingToDomainMapper()
    }
}