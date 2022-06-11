package com.example.github_trending.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TrendingEntity::class], version = 1)
abstract class GithubDatabase : RoomDatabase() {

    abstract fun githubTrendingDao(): GithubTrendingDao

}
