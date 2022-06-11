package com.example.github_trending.data.source.remote

object EndPoints {

    const val BASE_URL = "https://api.github.com"

    const val TRENDING_URL = "$BASE_URL/search/repositories?q=language=+sort:stars"

}