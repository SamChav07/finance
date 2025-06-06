package com.finance.finance.DTOs.response

import com.finance.finance.model.TipoEgreso
import java.time.LocalDate

data class EgresoResponseDTO(
    val id: Long,
    val categoria: String,
    val subcategoria: String,
    val descripcion: String,
    val fecha: LocalDate,
    val monto: Int,
    val tipo: TipoEgreso,
    val usuario: UsuarioResponseDTO
)