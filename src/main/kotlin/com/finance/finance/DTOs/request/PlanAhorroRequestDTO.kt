package com.finance.finance.DTOs.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class PlanAhorroRequestDTO(
    @field:NotBlank(message = "El nombre es obligatorio")
    val nombre: String,

    @field:NotBlank(message = "La descripción de la meta es obligatoria")
    val descripcionMeta: String,

    @field:NotBlank(message = "La fecha de inicio es obligatoria")
    val fechaInicio: String,

    @field:Min(value = 0, message = "El monto meta debe ser mayor o igual a 0")
    val montoMeta: Int,

    @field:Min(value = 0, message = "El monto ahorrado debe ser mayor o igual a 0")
    val montoAhorrado: Int,

    @field:Min(value = 1, message = "El plazo en meses debe ser al menos 1")
    val plazoMeses: Int,

    @field:NotNull(message = "El usuarioId es obligatorio")
    val usuarioId: Long
)