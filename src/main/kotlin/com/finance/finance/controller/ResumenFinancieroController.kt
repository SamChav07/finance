package com.finance.finance.controller

import com.finance.finance.DTOs.request.ResumenFinancieroRequestDTO
import com.finance.finance.DTOs.response.ResumenFinancieroResponseDTO
import com.finance.finance.generics.GenericDTOController
import com.finance.finance.model.ResumenFinanciero
import com.finance.finance.service.ResumenFinancieroService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/resumenes")
class ResumenFinancieroController(service: ResumenFinancieroService) :
    GenericDTOController<ResumenFinanciero, Long, ResumenFinancieroRequestDTO, ResumenFinancieroResponseDTO>(service)