package com.example.github_trending.data.source.mapper

import com.example.github_trending.data.source.local.TrendingEntity
import com.example.github_trending.data.utils.ModelMapper
import com.example.github_trending.domain.entity.TrendingDomainModel


/**
 * mapping the TrendingEntity data from database to TrendingDomainModel for domain layer
 *
 * **/
class TrendingToDomainMapper : ModelMapper<TrendingEntity, TrendingDomainModel> {

    override fun mapToRestaurantModel(model: TrendingEntity): TrendingDomainModel {
        return TrendingDomainModel(
            model.description,
            model.language,
            model.stargazersCount,
            model.owner.avatarUrl,
            model.owner.login
        )

    }




/**
 * public method
 * @return  List<TrendingDomainModel> to for domain
 * */
    fun toDomainList(initial: List<TrendingEntity>?): List<TrendingDomainModel>?{
        return initial?.map { mapToRestaurantModel(it) }
    }



}