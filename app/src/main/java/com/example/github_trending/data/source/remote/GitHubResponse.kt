package com.example.github_trending.data.source.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GitHubResponse(
    @SerialName("items")
    val items: List<Item>,
)


@Serializable
data class Item(
    @SerialName("id")
    val id: Int,
    @SerialName("description")
    val description: String,
    @SerialName("language")
    val language: String?,
    @SerialName("owner")
    val owner: Owner,
    @SerialName("stargazers_count")
    val stargazersCount: Int,
)


@Serializable
data class Owner(
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("login")
    val login: String,
)