package com.finance.finance.DTOs.response

data class PlanAhorroResponseDTO(
    val id: Long,
    val nombre: String,
    val descripcionMeta: String,
    val fechaInicio: String,
    val montoMeta: Int,
    val montoAhorrado: Int,
    val plazoMeses: Int,
    val usuario: UsuarioResponseDTO
)