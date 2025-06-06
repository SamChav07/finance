package com.finance.finance.DTOs.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UsuarioRequestDTO(
    @field:NotBlank(message = "El nombre es obligatorio")
    val nombre: String,

    @field:NotBlank(message = "El email es obligatorio")
    @field:Email(message = "El email debe ser válido")
    val email: String,

    @field:NotBlank(message = "La contraseña es obligatoria")
    @field:Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    val password: String,

    @field:NotBlank(message = "La frecuencia de ingreso es obligatoria")
    val frecuenciaIngreso: String,

    @field:Min(value = 0, message = "El monto de ingreso debe ser mayor o igual a 0")
    val montoIngreso: Int
)