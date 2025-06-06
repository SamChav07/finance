package com.finance.finance.controller

import com.finance.finance.DTOs.request.PlanAhorroRequestDTO
import com.finance.finance.DTOs.response.PlanAhorroResponseDTO
import com.finance.finance.generics.GenericDTOController
import com.finance.finance.model.PlanAhorro
import com.finance.finance.service.PlanAhorroService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/planes-ahorro")
class PlanAhorroController(service: PlanAhorroService) :
    GenericDTOController<PlanAhorro, Long, PlanAhorroRequestDTO, PlanAhorroResponseDTO>(service)