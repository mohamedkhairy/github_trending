package com.example.github_trending.data.source.remote.service


import com.example.github_trending.data.source.remote.EndPoints
import com.example.github_trending.data.source.remote.GitHubResponse
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

@ViewModelScoped
class TrendingGithubServiceImpl @Inject constructor(val httpClient: HttpClient): TrendingGithubService {


    override suspend fun callTrendingGithub(): GitHubResponse {
        return httpClient.get<GitHubResponse> {
//            this.apiUrl()
            url(EndPoints.TRENDING_URL)
        }
    }


}