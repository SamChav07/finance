package com.finance.finance.service

import com.finance.finance.DTOs.request.IngresoRequestDTO
import com.finance.finance.DTOs.response.IngresoResponseDTO
import com.finance.finance.generics.GenericDTOServiceImpl
import com.finance.finance.mapper.IngresoMapper
import com.finance.finance.model.Ingreso
import com.finance.finance.repository.IngresoRepository
import org.springframework.stereotype.Service

@Service
class IngresoService(
    repository: IngresoRepository,
    mapper: IngresoMapper
) : GenericDTOServiceImpl<Ingreso, Long, IngresoRequestDTO, IngresoResponseDTO>(repository, mapper) {

    override fun toEntity(dto: IngresoRequestDTO): Ingreso {
        return mapper.toEntity(dto)
    }

    override fun toResponse(entity: Ingreso): IngresoResponseDTO {
        return mapper.toResponse(entity)
    }

    override fun updateEntityFromDTO(dto: IngresoRequestDTO, entity: Ingreso): Ingreso {
        return mapper.updateEntityFromDTO(dto, entity)
    }
}