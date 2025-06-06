package com.finance.finance.generics

import com.finance.finance.exception.NotFoundException

abstract class GenericDTOServiceImpl<
        Entity : GenericEntity,
        ID : Any,
        ReqDTO,
        ResDTO
        >(
    protected val repository: GenericRepository<Entity, ID>,
    protected val mapper: GenericMapper<ReqDTO, ResDTO, Entity>
) : GenericDTOService<Entity, ID, ReqDTO, ResDTO> {

    protected open fun toEntity(dto: ReqDTO): Entity {
        return mapper.toEntity(dto)
    }

    protected open fun toResponse(entity: Entity): ResDTO {
        return mapper.toResponse(entity)
    }

    protected abstract fun updateEntityFromDTO(dto: ReqDTO, entity: Entity): Entity

    override fun save(dto: ReqDTO): ResDTO {
        val entity = toEntity(dto)
        return toResponse(repository.save(entity))
    }

    override fun findById(id: ID): ResDTO? {
        val entity = repository.findById(id)
            .orElseThrow { NotFoundException("Elemento con id $id no encontrado") }
        return mapper.toResponse(entity)
    }

    override fun findAll(): List<ResDTO> {
        return repository.findAll().map { toResponse(it) }
    }

    override fun update(id: ID, dto: ReqDTO): ResDTO? {
        val existing = repository.findById(id)
            .orElseThrow { NotFoundException("Elemento con id $id no encontrado para actualizar") }

        val updated = mapper.updateEntityFromDTO(dto, existing)
        val saved = repository.save(updated)
        return mapper.toResponse(saved)
    }

    override fun deleteById(id: ID) {
        if (!repository.existsById(id)) {
            throw NotFoundException("Elemento con id $id no encontrado para eliminar")
        }
        repository.deleteById(id)
    }
}