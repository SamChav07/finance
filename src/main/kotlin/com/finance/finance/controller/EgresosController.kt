package com.finance.finance.controller

import com.finance.finance.generics.GenericController
import com.finance.finance.model.Egreso
import com.finance.finance.generics.GenericService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/egresos")
class EgresoController(service: GenericService<Egreso, Long>) : GenericController<Egreso, Long>(service)