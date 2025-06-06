package com.finance.finance.service

import com.finance.finance.DTOs.request.UsuarioRequestDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.generics.GenericDTOServiceImpl
import com.finance.finance.mapper.UsuarioMapper
import com.finance.finance.model.Usuario
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    repository: UsuarioRepository,
    mapper: UsuarioMapper
) : GenericDTOServiceImpl<Usuario, Long, UsuarioRequestDTO, UsuarioResponseDTO>(repository, mapper) {

    override fun toEntity(dto: UsuarioRequestDTO): Usuario {
        return mapper.toEntity(dto)
    }

    override fun toResponse(entity: Usuario): UsuarioResponseDTO {
        return mapper.toResponse(entity)
    }

    override fun updateEntityFromDTO(dto: UsuarioRequestDTO, entity: Usuario): Usuario {
        return mapper.updateEntityFromDTO(dto, entity)
    }
}