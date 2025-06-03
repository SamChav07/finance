package com.finance.finance.service

import com.finance.finance.generics.GenericService
import com.finance.finance.generics.GenericServiceImpl
import com.finance.finance.repository.PlanAhorroRepository
import org.springframework.stereotype.Service
import com.finance.finance.model.PlanAhorro

@Service
class PlanAhorroService(repository: PlanAhorroRepository) : GenericServiceImpl<PlanAhorro, Long>(repository),
    GenericService<PlanAhorro, Long>