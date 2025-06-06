package com.finance.finance.service

import com.finance.finance.DTOs.request.PlanAhorroRequestDTO
import com.finance.finance.DTOs.response.PlanAhorroResponseDTO
import com.finance.finance.generics.GenericDTOServiceImpl
import com.finance.finance.mapper.PlanAhorroMapper
import com.finance.finance.model.PlanAhorro
import com.finance.finance.repository.PlanAhorroRepository
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class PlanAhorroService(
    private val usuarioRepository: UsuarioRepository,
    repository: PlanAhorroRepository,
    mapper: PlanAhorroMapper
) : GenericDTOServiceImpl<PlanAhorro, Long, PlanAhorroRequestDTO, PlanAhorroResponseDTO>(repository, mapper) {

    override fun toEntity(dto: PlanAhorroRequestDTO): PlanAhorro {
        return mapper.toEntity(dto)
    }

    override fun toResponse(entity: PlanAhorro): PlanAhorroResponseDTO {
        return mapper.toResponse(entity)
    }

    override fun updateEntityFromDTO(dto: PlanAhorroRequestDTO, entity: PlanAhorro): PlanAhorro {
        return mapper.updateEntityFromDTO(dto, entity)
    }
}