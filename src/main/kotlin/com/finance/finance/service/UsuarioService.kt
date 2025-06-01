package com.finance.finance.service

import com.finance.finance.model.PlanAhorro
import com.finance.finance.model.Usuario
import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val planificadorFinanciero: PlanificadorFinanciero
) : GenericServiceImpl<Usuario, Long>(usuarioRepository), GenericService<Usuario, Long> {

    fun crearPlanSugeridoParaUsuario(usuarioId: Long): PlanAhorro {
        val usuario = usuarioRepository.findById(usuarioId).orElseThrow()
        return planificadorFinanciero.generarPlanAhorro(usuario)
    }

    fun sugerirDistribucionParaUsuario(usuarioId: Long): Map<String, Int> {
        val usuario = usuarioRepository.findById(usuarioId).orElseThrow()
        return planificadorFinanciero.sugerirDistribucionGastos(usuario)
    }
}