package com.finance.finance.DTOs.request

import com.finance.finance.model.TipoFuente
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class IngresoRequestDTO(
    @field:NotBlank(message = "El concepto es obligatorio")
    val concepto: String,

    @field:NotNull(message = "La fecha es obligatoria")
    val fecha: LocalDate,

    @field:Min(value = 0, message = "El monto debe ser mayor o igual a 0")
    val monto: Int,

    @field:NotNull(message = "La fuente es obligatoria")
    val fuente: TipoFuente,

    @field:NotNull(message = "El usuarioId es obligatorio")
    val usuarioId: Long
)