package com.finance.finance.service

import com.finance.finance.model.GenericEntity
import com.finance.finance.repository.GenericRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

open class GenericServiceImpl<T : GenericEntity, ID : Any>(private val repository: GenericRepository<T, ID>) : GenericService<T, ID> {

    @Transactional(readOnly = true)
    override fun findAll(): List<T> {
        return repository.findAll()
    }

    @Transactional(readOnly = true)
    override fun findById(id: ID): T? {
        return repository.findByIdOrNull(id)
    }

    @Transactional
    override fun save(entity: T): T {
        return repository.save(entity)
    }

    @Transactional
    override fun deleteById(id: ID) {
        if (repository.existsById(id)) {
            repository.deleteById(id)
        } else {
            throw IllegalArgumentException("Entidad con el id: $id no encontrada")
        }
    }

    @Transactional
    override fun update(id: ID, updatedEntity: T): T? {
        if (repository.existsById(id)) {

            if (id is Long) {
                updatedEntity.id = id
            } else {

                throw IllegalArgumentException("El tipo de ID esperado para la entidad no es Long.")
            }
            return repository.save(updatedEntity)
        }
        return null
    }
}