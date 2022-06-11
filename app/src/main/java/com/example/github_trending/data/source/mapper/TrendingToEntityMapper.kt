package com.example.github_trending.data.source.mapper

import com.example.github_trending.data.source.local.Owner
import com.example.github_trending.data.source.local.TrendingEntity
import com.example.github_trending.data.source.remote.GitHubResponse
import com.example.github_trending.data.utils.ModelMapper

class TrendingToEntityMapper: ModelMapper<GitHubResponse, List<TrendingEntity>> {

    override fun mapToRestaurantModel(model: GitHubResponse): List<TrendingEntity> {
        return model.items.map {
            TrendingEntity(
                it.id,
                it.description,
                it.language,
                Owner(it.owner.avatarUrl , it.owner.login),
                it.stargazersCount
            )
        }

    }




    fun toEntityList(initial: GitHubResponse): List<TrendingEntity>
        = mapToRestaurantModel(initial)




}