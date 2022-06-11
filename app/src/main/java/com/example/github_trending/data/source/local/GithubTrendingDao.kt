package com.example.github_trending.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.github_trending.data.source.local.TrendingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubTrendingDao {

    @Query("SELECT * FROM TRENDING_TABLE")
     fun getAll(): Flow<List<TrendingEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(trendingList: List<TrendingEntity>)

//    @Query("UPDATE character SET base64 = :image WHERE id = :id")
//    fun updateImage(id: Int, image: String)

    @Query("DELETE FROM trending_table")
    fun deleteAll()



    ////////// Query for last five days //////////////


//    @Query("SELECT * FROM forecastlastfivedays")
//    fun getLastFiveDaysData(): Flow<List<ForecastLastFiveDaysEntity>?>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun saveLastFiveDaysData(forecast: List<ForecastLastFiveDaysEntity>)

//    @Query("UPDATE character SET base64 = :image WHERE id = :id")
//    fun updateImage(id: Int, image: String)

//    @Query("DELETE FROM forecastlastfivedays")
//    fun deleteLastFiveDaysData()
}