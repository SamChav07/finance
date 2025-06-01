package com.finance.finance.service

import com.finance.finance.model.PlanAhorro
import com.finance.finance.model.Usuario
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PlanificadorFinanciero {

    fun generarPlanAhorro(usuario: Usuario): PlanAhorro {
        val porcentajeAhorroSugerido = 0.20
        val montoMeta = (usuario.montoIngreso * 6)
        val montoAhorrado = 0
        val plazoMeses = 12

        return PlanAhorro(
            nombre = "Ahorro Automático",
            descripcionMeta = "Plan sugerido para alcanzar una reserva de emergencia",
            fechaInicio = LocalDate.now().toString(),
            montoMeta = montoMeta,
            montoAhorrado = montoAhorrado,
            plazoMeses = plazoMeses,
            usuario = usuario
        )
    }

    fun sugerirDistribucionGastos(usuario: Usuario): Map<String, Int> {
        val ingreso = usuario.montoIngreso
        val necesidades = (ingreso * 0.50).toInt()
        val ahorro = (ingreso * 0.20).toInt()
        val estiloVida = (ingreso * 0.30).toInt()

        return mapOf(
            "Necesidades básicas" to necesidades,
            "Ahorro sugerido" to ahorro,
            "Estilo de vida y ocio" to estiloVida
        )
    }
}