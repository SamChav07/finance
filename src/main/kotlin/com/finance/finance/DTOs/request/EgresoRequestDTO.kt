package com.finance.finance.DTOs.request

import com.finance.finance.model.TipoEgreso
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate


data class EgresoRequestDTO(
    @field:NotBlank(message = "La categoría es obligatoria")
    val categoria: String,

    @field:NotBlank(message = "La subcategoría es obligatoria")
    val subcategoria: String,

    @field:NotBlank(message = "La descripción es obligatoria")
    val descripcion: String,

    @field:NotNull(message = "La fecha es obligatoria")
    val fecha: LocalDate,

    @field:Min(value = 0, message = "El monto debe ser mayor o igual a 0")
    val monto: Int,

    @field:NotNull(message = "El tipo es obligatorio")
    val tipo: TipoEgreso,

    @field:NotNull(message = "El usuarioId es obligatorio")
    val usuarioId: Long
)