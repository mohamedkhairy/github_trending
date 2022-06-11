package com.example.github_trending.data.utils

interface ModelMapper <T, DomainModel>{

    fun mapToRestaurantModel(model: T): DomainModel

}