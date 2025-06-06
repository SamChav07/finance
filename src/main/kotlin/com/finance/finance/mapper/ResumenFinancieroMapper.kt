package com.finance.finance.mapper

import com.finance.finance.DTOs.request.ResumenFinancieroRequestDTO
import com.finance.finance.DTOs.response.ResumenFinancieroResponseDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.generics.GenericMapper
import com.finance.finance.model.ResumenFinanciero
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Component

@Component
class ResumenFinancieroMapper(
    private val usuarioRepository: UsuarioRepository
) : GenericMapper<ResumenFinancieroRequestDTO, ResumenFinancieroResponseDTO, ResumenFinanciero> {

    override fun toEntity(dto: ResumenFinancieroRequestDTO): ResumenFinanciero {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow {
            RuntimeException("Usuario no encontrado")
        }
        return ResumenFinanciero(
            ahorroSugerido = dto.ahorroSugerido,
            egresosTotales = dto.egresosTotales,
            ingresosTotales = dto.ingresosTotales,
            saldoDisponible = dto.saldoDisponible,
            usuario = usuario
        )
    }

    override fun toResponse(entity: ResumenFinanciero): ResumenFinancieroResponseDTO {
        return ResumenFinancieroResponseDTO(
            id = entity.id!!,
            ahorroSugerido = entity.ahorroSugerido,
            egresosTotales = entity.egresosTotales,
            ingresosTotales = entity.ingresosTotales,
            saldoDisponible = entity.saldoDisponible,
            usuario = UsuarioResponseDTO(
                id = entity.usuario.id!!,
                nombre = entity.usuario.nombre,
                email = entity.usuario.email,
                frecuenciaIngreso = entity.usuario.frecuenciaIngreso,
                montoIngreso = entity.usuario.montoIngreso
            )
        )
    }

    override fun updateEntityFromDTO(dto: ResumenFinancieroRequestDTO, entity: ResumenFinanciero): ResumenFinanciero {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow {
            RuntimeException("Usuario no encontrado")
        }
        return entity.copy(
            ahorroSugerido = dto.ahorroSugerido,
            egresosTotales = dto.egresosTotales,
            ingresosTotales = dto.ingresosTotales,
            saldoDisponible = dto.saldoDisponible,
            usuario = usuario
        )
    }
}