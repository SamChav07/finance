package com.finance.finance.generics

interface GenericDTOService<Entity : GenericEntity, ID : Any, RequestDTO, ResponseDTO> {
    fun findAll(): List<ResponseDTO>
    fun findById(id: ID): ResponseDTO?
    fun save(dto: RequestDTO): ResponseDTO
    fun update(id: ID, dto: RequestDTO): ResponseDTO?
    fun deleteById(id: ID)
}