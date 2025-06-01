package com.finance.finance.controller

import com.finance.finance.model.PlanAhorro
import com.finance.finance.model.Usuario
import com.finance.finance.service.GenericService
import com.finance.finance.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/plan-financiero")
class PlanificadorFinancieroController(
    service: GenericService<Usuario, Long>,
    private val usuarioService: UsuarioService
) : GenericController<Usuario, Long>(service) {

    @PostMapping("/generar-plan/{usuarioId}")
    fun generarPlan(@PathVariable usuarioId: Long): ResponseEntity<PlanAhorro> {
        val plan = usuarioService.crearPlanSugeridoParaUsuario(usuarioId)
        return ResponseEntity.ok(plan)
    }

    @GetMapping("/sugerencia-gastos/{usuarioId}")
    fun sugerenciaGastos(@PathVariable usuarioId: Long): ResponseEntity<Map<String, Int>> {
        val sugerencias = usuarioService.sugerirDistribucionParaUsuario(usuarioId)
        return ResponseEntity.ok(sugerencias)
    }
}