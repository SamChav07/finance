package com.finance.finance.mapper

import com.finance.finance.DTOs.request.UsuarioRequestDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.model.Usuario
import com.finance.finance.generics.GenericMapper
import org.springframework.stereotype.Component

@Component
class UsuarioMapper : GenericMapper<UsuarioRequestDTO, UsuarioResponseDTO, Usuario> {

    override fun toEntity(dto: UsuarioRequestDTO): Usuario = Usuario(
        nombre = dto.nombre,
        email = dto.email,
        frecuenciaIngreso = dto.frecuenciaIngreso,
        montoIngreso = dto.montoIngreso,
        password = dto.password
    )

    override fun toResponse(entity: Usuario): UsuarioResponseDTO = UsuarioResponseDTO(
        id = entity.id!!,
        nombre = entity.nombre,
        email = entity.email,
        frecuenciaIngreso = entity.frecuenciaIngreso,
        montoIngreso = entity.montoIngreso
    )

    override fun updateEntityFromDTO(dto: UsuarioRequestDTO, entity: Usuario): Usuario {
        entity.nombre = dto.nombre
        entity.email = dto.email
        entity.frecuenciaIngreso = dto.frecuenciaIngreso
        entity.montoIngreso = dto.montoIngreso
        entity.password = dto.password
        return entity
    }
}