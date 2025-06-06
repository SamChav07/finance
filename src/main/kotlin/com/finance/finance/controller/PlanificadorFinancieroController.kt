package com.finance.finance.controller

import com.finance.finance.model.PlanAhorro
import com.finance.finance.model.Usuario
import com.finance.finance.service.PlanificadorFinancieroService
import com.finance.finance.service.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/plan-financiero")
class PlanificadorFinancieroController(
    private val usuarioService: UsuarioService,
    private val planificadorFinanciero: PlanificadorFinancieroService
) {

    @PostMapping("/generar-plan/{usuarioId}")
    fun generarPlan(@PathVariable usuarioId: Long): ResponseEntity<PlanAhorro> {
        val usuarioDto = usuarioService.findById(usuarioId)
        if (usuarioDto == null) return ResponseEntity.notFound().build()
        val plan = planificadorFinanciero.generarPlanAhorro(usuarioDto)
        return ResponseEntity.ok(plan)
    }

    @GetMapping("/sugerencia-gastos/{usuarioId}")
    fun sugerenciaGastos(@PathVariable usuarioId: Long): ResponseEntity<Map<String, Int>> {
        val usuarioDto = usuarioService.findById(usuarioId)
        if (usuarioDto == null) return ResponseEntity.notFound().build()
        val sugerencias = planificadorFinanciero.sugerirDistribucionGastos(usuarioDto)
        return ResponseEntity.ok(sugerencias)
    }
}
// a este no se uso el genericController por razones de logica de negocio y se evita exponer metodos CRUD del usuario en el conteiller
// por si preguntan es Single Responsability