package com.finance.finance.controller

import com.finance.finance.model.ResumenFinanciero
import com.finance.finance.service.GenericService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/resumenes")
class ResumenFinancieroController(service: GenericService<ResumenFinanciero, Long>) : GenericController<ResumenFinanciero, Long>(service)