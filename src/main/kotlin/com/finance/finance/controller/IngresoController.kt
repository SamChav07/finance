package com.finance.finance.controller

import com.finance.finance.generics.GenericController
import com.finance.finance.model.Ingreso
import com.finance.finance.generics.GenericService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ingresos")
class IngresoController(service: GenericService<Ingreso, Long>) : GenericController<Ingreso, Long>(service)