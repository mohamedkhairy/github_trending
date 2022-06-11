package com.example.github_trending.data.source.remote.service

import com.example.github_trending.data.source.remote.GitHubResponse

interface TrendingGithubService {

    suspend fun callTrendingGithub(): GitHubResponse

}