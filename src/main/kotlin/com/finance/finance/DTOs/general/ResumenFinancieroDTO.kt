package com.finance.finance.DTOs.general

import com.finance.finance.DTOs.response.UsuarioResponseDTO

data class ResumenFinancieroDTO(
    val id: Long,
    val ahorroSugerido: Int,
    val egresosTotales: Int,
    val ingresosTotales: Int,
    val saldoDisponible: Int,
    val usuario: UsuarioResponseDTO
)