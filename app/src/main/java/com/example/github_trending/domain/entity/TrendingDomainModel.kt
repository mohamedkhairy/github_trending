package com.example.github_trending.domain.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class TrendingDomainModel(
    val description: String,
    val language: String,
    val stargazersCount: Int,
    val avatarUrl: String,
    val ownerName: String,
)
