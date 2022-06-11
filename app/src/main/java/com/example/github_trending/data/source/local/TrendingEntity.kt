package com.example.github_trending.data.source.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Entity(tableName = "trending_table")
data class TrendingEntity(
    @PrimaryKey
    val id: Int,
    val description: String,
    val language: String,
    @Embedded
    val owner: Owner,
    val stargazersCount: Int,

)

data class Owner(
    val avatarUrl: String,
    val login: String,
)