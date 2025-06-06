package com.finance.finance.DTOs.request

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class ResumenFinancieroRequestDTO(
    @field:Min(value = 0, message = "El ahorro sugerido debe ser mayor o igual a 0")
    val ahorroSugerido: Int,

    @field:Min(value = 0, message = "Los egresos totales deben ser mayor o igual a 0")
    val egresosTotales: Int,

    @field:Min(value = 0, message = "Los ingresos totales deben ser mayor o igual a 0")
    val ingresosTotales: Int,

    val saldoDisponible: Int,  // Puede ser negativo, por eso no pongo @Min aquí

    @field:NotNull(message = "El usuarioId es obligatorio")
    val usuarioId: Long
)