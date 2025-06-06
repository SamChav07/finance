package com.finance.finance.generics

interface GenericMapper<ReqDTO, ResDTO, Entity> {

    fun toEntity(dto: ReqDTO): Entity
    fun toResponse(entity: Entity): ResDTO
    fun updateEntityFromDTO(dto: ReqDTO, entity: Entity): Entity
}