package com.finance.finance.controller

import com.finance.finance.model.PlanAhorro
import com.finance.finance.service.GenericService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/planes-ahorro")
class PlanAhorroController(service: GenericService<PlanAhorro, Long>) : GenericController<PlanAhorro, Long>(service)