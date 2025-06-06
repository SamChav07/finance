package com.finance.finance.DTOs.response

data class UsuarioResponseDTO(
    val id: Long?,
    val nombre: String,
    val email: String,
    val frecuenciaIngreso: String,
    val montoIngreso: Int
)
