package com.example.github_trending.domain.entity


data class TrendingDomainModel(
    val description: String,
    val language: String?,
    val stargazersCount: Int,
    val avatarUrl: String,
    val ownerName: String,
)
