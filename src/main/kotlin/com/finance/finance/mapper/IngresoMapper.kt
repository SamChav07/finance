package com.finance.finance.mapper

import com.finance.finance.DTOs.request.IngresoRequestDTO
import com.finance.finance.DTOs.response.IngresoResponseDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.generics.GenericMapper
import com.finance.finance.model.Ingreso
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Component

@Component
class IngresoMapper(
    private val usuarioRepository: UsuarioRepository
) : GenericMapper<IngresoRequestDTO, IngresoResponseDTO, Ingreso> {

    override fun toEntity(dto: IngresoRequestDTO): Ingreso {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow()
        return Ingreso(
            concepto = dto.concepto,
            fecha = dto.fecha,
            monto = dto.monto,
            fuente = dto.fuente,
            usuario = usuario
        )
    }

    override fun toResponse(entity: Ingreso): IngresoResponseDTO {
        return IngresoResponseDTO(
            id = entity.id!!,
            concepto = entity.concepto,
            fecha = entity.fecha,
            monto = entity.monto,
            fuente = entity.fuente,
            usuario = UsuarioResponseDTO(
                id = entity.usuario.id!!,
                nombre = entity.usuario.nombre,
                email = entity.usuario.email,
                frecuenciaIngreso = entity.usuario.frecuenciaIngreso,
                montoIngreso = entity.usuario.montoIngreso
            )
        )
    }

    override fun updateEntityFromDTO(dto: IngresoRequestDTO, entity: Ingreso): Ingreso {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow()
        return entity.copy(
            concepto = dto.concepto,
            fecha = dto.fecha,
            monto = dto.monto,
            fuente = dto.fuente,
            usuario = usuario
        )
    }
}