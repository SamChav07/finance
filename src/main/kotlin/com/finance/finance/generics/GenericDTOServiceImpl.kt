package com.finance.finance.generics

abstract class GenericDTOServiceImpl<
        Entity : GenericEntity,
        ID : Any,
        ReqDTO,
        ResDTO
        >(
    protected val repository: GenericRepository<Entity, ID>,
    protected val mapper: GenericMapper<ReqDTO, ResDTO, Entity>
) : GenericDTOService<Entity, ID, ReqDTO, ResDTO> {

    /**
     * Si necesitas lógica especial (como buscar relaciones),
     * sobrescribe esto en el servicio concreto.
     */
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
        return entity.map { toResponse(it) }.orElse(null)
    }

    override fun findAll(): List<ResDTO> {
        return repository.findAll().map { toResponse(it) }
    }

    override fun update(id: ID, dto: ReqDTO): ResDTO? {
        val existing = repository.findById(id).orElse(null) ?: return null
        val updatedEntity = updateEntityFromDTO(dto, existing)
        updatedEntity.id = id as? Long
        return toResponse(repository.save(updatedEntity))
    }

    override fun deleteById(id: ID) {
        repository.deleteById(id)
    }
}