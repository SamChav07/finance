package com.finance.finance.DTOs.request

import jakarta.validation.constraints.NotBlank

data class GastoExtraRequestDTO(
    @field:NotBlank(message = "El motivo es obligatorio")
    val motivo: String
)