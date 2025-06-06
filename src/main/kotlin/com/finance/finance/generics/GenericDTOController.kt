package com.finance.finance.generics

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

open class GenericDTOController<
        Entity : GenericEntity,
        ID : Any,
        RequestDTO,
        ResponseDTO
        >(
    private val service: GenericDTOService<Entity, ID, RequestDTO, ResponseDTO>
) {
    @GetMapping
    fun getAll(): ResponseEntity<List<ResponseDTO>> =
        ResponseEntity.ok(service.findAll())

    @GetMapping("/{id}")
    fun getById(@PathVariable id: ID): ResponseEntity<ResponseDTO> {
        val dto = service.findById(id)
        return if (dto != null) ResponseEntity.ok(dto) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@Valid @RequestBody dto: RequestDTO): ResponseEntity<ResponseDTO> =
        ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto))

    @PutMapping("/{id}")
    fun update(@PathVariable id: ID, @Valid @RequestBody dto: RequestDTO): ResponseEntity<ResponseDTO> {
        val updated = service.update(id, dto)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<Unit> {
        service.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}