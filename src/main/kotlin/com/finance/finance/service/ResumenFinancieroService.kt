package com.finance.finance.service

import com.finance.finance.DTOs.request.ResumenFinancieroRequestDTO
import com.finance.finance.DTOs.response.ResumenFinancieroResponseDTO
import com.finance.finance.generics.GenericDTOServiceImpl
import com.finance.finance.mapper.ResumenFinancieroMapper
import com.finance.finance.model.ResumenFinanciero
import com.finance.finance.repository.ResumenFinancieroRepository
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class ResumenFinancieroService(
    private val usuarioRepository: UsuarioRepository,
    repository: ResumenFinancieroRepository,
    mapper: ResumenFinancieroMapper
) : GenericDTOServiceImpl<ResumenFinanciero, Long, ResumenFinancieroRequestDTO, ResumenFinancieroResponseDTO>(
    repository,
    mapper
) {

    override fun toEntity(dto: ResumenFinancieroRequestDTO): ResumenFinanciero {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow {
            RuntimeException("Usuario no encontrado")
        }
        return mapper.toEntity(dto.copy(usuarioId = usuario.id!!)) // o simplemente mapper.toEntity(dto)
    }

    override fun toResponse(entity: ResumenFinanciero): ResumenFinancieroResponseDTO {
        return mapper.toResponse(entity)
    }

    override fun updateEntityFromDTO(dto: ResumenFinancieroRequestDTO, entity: ResumenFinanciero): ResumenFinanciero {
        val usuario = usuarioRepository.findById(dto.usuarioId).orElseThrow {
            RuntimeException("Usuario no encontrado")
        }
        return mapper.updateEntityFromDTO(dto, entity)
    }
}