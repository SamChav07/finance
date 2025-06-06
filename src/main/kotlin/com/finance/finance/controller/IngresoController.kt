package com.finance.finance.controller

import com.finance.finance.DTOs.request.IngresoRequestDTO
import com.finance.finance.DTOs.response.IngresoResponseDTO
import com.finance.finance.generics.GenericDTOController
import com.finance.finance.model.Ingreso
import com.finance.finance.service.IngresoService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ingresos")
class IngresoController(service: IngresoService) :
    GenericDTOController<Ingreso, Long, IngresoRequestDTO, IngresoResponseDTO>(service)