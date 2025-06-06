package com.finance.finance.mapper

import com.finance.finance.DTOs.request.EgresoRequestDTO
import com.finance.finance.DTOs.response.EgresoResponseDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.model.Egreso
import com.finance.finance.model.Usuario
import com.finance.finance.generics.GenericMapper
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Component

@Component
class EgresoMapper(
    private val usuarioRepository: UsuarioRepository
) : GenericMapper<EgresoRequestDTO, EgresoResponseDTO, Egreso> {

    override fun toEntity(dto: EgresoRequestDTO): Egreso {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow {
            IllegalArgumentException("Usuario no encontrado con id ${dto.usuarioId}")
        }
        return Egreso(
            categoria = dto.categoria,
            subcategoria = dto.subcategoria,
            descripcion = dto.descripcion,
            fecha = dto.fecha,
            monto = dto.monto,
            tipo = dto.tipo,
            usuario = usuario
        )
    }

    override fun toResponse(entity: Egreso): EgresoResponseDTO = EgresoResponseDTO(
        id = entity.id!!,
        categoria = entity.categoria,
        subcategoria = entity.subcategoria,
        descripcion = entity.descripcion,
        fecha = entity.fecha,
        monto = entity.monto,
        tipo = entity.tipo,
        usuario = UsuarioResponseDTO(
            id = entity.usuario.id!!,
            nombre = entity.usuario.nombre,
            email = entity.usuario.email,
            frecuenciaIngreso = entity.usuario.frecuenciaIngreso,
            montoIngreso = entity.usuario.montoIngreso
        )
    )

    override fun updateEntityFromDTO(dto: EgresoRequestDTO, entity: Egreso): Egreso {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow()
        return entity.copy(
            categoria = dto.categoria,
            subcategoria = dto.subcategoria,
            descripcion = dto.descripcion,
            fecha = dto.fecha,
            monto = dto.monto,
            tipo = dto.tipo,
            usuario = usuario
        )
    }
}