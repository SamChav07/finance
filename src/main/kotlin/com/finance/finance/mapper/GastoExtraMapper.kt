package com.finance.finance.mapper

import com.finance.finance.DTOs.request.GastoExtraRequestDTO
import com.finance.finance.DTOs.response.GastoExtraResponseDTO
import com.finance.finance.model.GastoExtra

object GastoExtraMapper {

    fun toEntity(dto: GastoExtraRequestDTO): GastoExtra = GastoExtra(
        motivo = dto.motivo
    )

    fun toResponse(gasto: GastoExtra): GastoExtraResponseDTO = GastoExtraResponseDTO(
        id = gasto.id!!,
        motivo = gasto.motivo
    )
}
