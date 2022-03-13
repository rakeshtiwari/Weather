package com.rakesht.weatherapp.data.mapper

interface BaseMapper<Dto, Entity> {
    fun mapToEntityFromDto(data: Dto?): Entity?
}