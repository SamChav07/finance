package com.finance.finance.controller

import com.finance.finance.generics.GenericController
import com.finance.finance.model.GastoExtra
import com.finance.finance.generics.GenericService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/gastos-extra")
class GastoExtraController(service: GenericService<GastoExtra, Long>) : GenericController<GastoExtra, Long>(service)