package com.finance.finance.service

import com.finance.finance.DTOs.request.EgresoRequestDTO
import com.finance.finance.DTOs.response.EgresoResponseDTO
import com.finance.finance.generics.GenericDTOServiceImpl
import com.finance.finance.mapper.EgresoMapper
import com.finance.finance.model.Egreso
import com.finance.finance.repository.EgresoRepository
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class EgresoService(
    private val usuarioRepository: UsuarioRepository,
    repository: EgresoRepository,
    mapper: EgresoMapper
) : GenericDTOServiceImpl<Egreso, Long, EgresoRequestDTO, EgresoResponseDTO>(repository, mapper) {

    override fun toEntity(dto: EgresoRequestDTO): Egreso {
        return mapper.toEntity(dto)
    }

    override fun toResponse(entity: Egreso): EgresoResponseDTO {
        return mapper.toResponse(entity)
    }

    override fun updateEntityFromDTO(dto: EgresoRequestDTO, entity: Egreso): Egreso {
        return mapper.updateEntityFromDTO(dto, entity)
    }
}