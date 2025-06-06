package com.finance.finance.controller

import com.finance.finance.DTOs.request.EgresoRequestDTO
import com.finance.finance.DTOs.response.EgresoResponseDTO
import com.finance.finance.generics.GenericDTOController
import com.finance.finance.model.Egreso
import com.finance.finance.service.EgresoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/egresos")
class EgresoController(service: EgresoService) :
    GenericDTOController<Egreso, Long, EgresoRequestDTO, EgresoResponseDTO>(service)