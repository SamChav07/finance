package com.finance.finance.DTOs.response

import com.finance.finance.model.TipoFuente
import java.time.LocalDate

data class IngresoResponseDTO(
    val id: Long,
    val concepto: String,
    val fecha: LocalDate,
    val monto: Int,
    val fuente: TipoFuente,
    val usuario: UsuarioResponseDTO
)