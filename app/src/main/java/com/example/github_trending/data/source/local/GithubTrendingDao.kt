package com.example.github_trending.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubTrendingDao {

    @Query("SELECT * FROM TRENDING_TABLE")
     fun getAll(): Flow<List<TrendingEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(trendingList: List<TrendingEntity>)

    @Query("DELETE FROM trending_table")
    fun deleteAll()


}