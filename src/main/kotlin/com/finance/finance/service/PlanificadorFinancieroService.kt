package com.finance.finance.service

import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.model.PlanAhorro
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PlanificadorFinancieroService(
    private val usuarioRepository: UsuarioRepository
) {
    fun generarPlanAhorro(usuario: UsuarioResponseDTO?): PlanAhorro {
        if (usuario == null) throw IllegalArgumentException("Usuario no puede ser null")

        val usuarioEntidad = usuarioRepository.findById(usuario.id)
            .orElseThrow { IllegalArgumentException("Usuario no encontrado con id: ${usuario.id}") }

        val montoMeta = usuario.montoIngreso * 6
        val montoAhorrado = 0
        val plazoMeses = 12

        return PlanAhorro(
            nombre = "Ahorro Automático",
            descripcionMeta = "Plan sugerido para alcanzar una reserva de emergencia",
            fechaInicio = LocalDate.now().toString(),
            montoMeta = montoMeta,
            montoAhorrado = montoAhorrado,
            plazoMeses = plazoMeses,
            usuario = usuarioEntidad
        )
    }

    fun sugerirDistribucionGastos(usuario: UsuarioResponseDTO?): Map<String, Int> {
        if (usuario == null) throw IllegalArgumentException("Usuario no puede ser null")

        val ingreso = usuario.montoIngreso
        return mapOf(
            "Necesidades básicas" to (ingreso * 0.50).toInt(),
            "Ahorro sugerido" to (ingreso * 0.20).toInt(),
            "Estilo de vida y ocio" to (ingreso * 0.30).toInt()
        )
    }
}