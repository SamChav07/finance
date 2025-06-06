package com.finance.finance.mapper

import com.finance.finance.DTOs.request.PlanAhorroRequestDTO
import com.finance.finance.DTOs.response.PlanAhorroResponseDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.generics.GenericMapper
import com.finance.finance.model.PlanAhorro
import com.finance.finance.model.Usuario
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Component

@Component
class PlanAhorroMapper(
    private val usuarioRepository: UsuarioRepository
) : GenericMapper<PlanAhorroRequestDTO, PlanAhorroResponseDTO, PlanAhorro> {

    override fun toEntity(dto: PlanAhorroRequestDTO): PlanAhorro {
        val usuario: Usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow()
        return PlanAhorro(
            nombre = dto.nombre,
            descripcionMeta = dto.descripcionMeta,
            fechaInicio = dto.fechaInicio,
            montoMeta = dto.montoMeta,
            montoAhorrado = dto.montoAhorrado,
            plazoMeses = dto.plazoMeses,
            usuario = usuario
        )
    }

    override fun toResponse(entity: PlanAhorro): PlanAhorroResponseDTO {
        return PlanAhorroResponseDTO(
            id = entity.id!!,
            nombre = entity.nombre,
            descripcionMeta = entity.descripcionMeta,
            fechaInicio = entity.fechaInicio,
            montoMeta = entity.montoMeta,
            montoAhorrado = entity.montoAhorrado,
            plazoMeses = entity.plazoMeses,
            usuario = UsuarioResponseDTO(
                id = entity.usuario.id,
                nombre = entity.usuario.nombre,
                email = entity.usuario.email,
                frecuenciaIngreso = entity.usuario.frecuenciaIngreso,
                montoIngreso = entity.usuario.montoIngreso
            )
        )
    }

    override fun updateEntityFromDTO(dto: PlanAhorroRequestDTO, entity: PlanAhorro): PlanAhorro {
        val usuario: Usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow()
        return entity.copy(
            nombre = dto.nombre,
            descripcionMeta = dto.descripcionMeta,
            fechaInicio = dto.fechaInicio,
            montoMeta = dto.montoMeta,
            montoAhorrado = dto.montoAhorrado,
            plazoMeses = dto.plazoMeses,
            usuario = usuario
        )
    }
}