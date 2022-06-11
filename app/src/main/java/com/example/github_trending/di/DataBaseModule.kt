package com.example.github_trending.di

import android.content.Context
import androidx.room.Room
import com.example.github_trending.data.source.local.GithubDatabase
import com.example.github_trending.data.source.local.GithubTrendingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : GithubDatabase =
        Room.databaseBuilder(context, GithubDatabase::class.java, "github_database")
            .build()

    @Provides
    @Singleton
    fun provideGithubTrendingDao(database: GithubDatabase) : GithubTrendingDao =
        database.githubTrendingDao()

}