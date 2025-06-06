package com.finance.finance.DTOs.response

data class ResumenFinancieroResponseDTO(
    val id: Long,
    val ahorroSugerido: Int,
    val egresosTotales: Int,
    val ingresosTotales: Int,
    val saldoDisponible: Int,
    val usuario: UsuarioResponseDTO
)