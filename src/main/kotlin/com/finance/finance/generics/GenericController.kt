package com.finance.finance.generics

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

open class GenericController<T : GenericEntity, ID : Any>(private val service: GenericService<T, ID>) {

    @GetMapping
    fun getAll(): ResponseEntity<List<T>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: ID): ResponseEntity<T> {
        val entity = service.findById(id)
        return if (entity != null) ResponseEntity.ok(entity) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody entity: T): ResponseEntity<T> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: ID, @RequestBody updatedEntity: T): ResponseEntity<T> {
        val result = service.update(id, updatedEntity)
        return if (result != null) ResponseEntity.ok(result) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID): ResponseEntity<Unit> {
        return try {
            service.deleteById(id)
            ResponseEntity.noContent().build()
        } catch (e: IllegalArgumentException) {
            ResponseEntity.notFound().build()
        }
    }
}