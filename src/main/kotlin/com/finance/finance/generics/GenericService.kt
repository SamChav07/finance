package com.finance.finance.generics

interface GenericService<T : GenericEntity, ID : Any> {
    fun findAll(): List<T>
    fun findById(id: ID): T?
    fun save(entity: T): T
    fun deleteById(id: ID)
    fun update(id: ID, updatedEntity: T): T?
}