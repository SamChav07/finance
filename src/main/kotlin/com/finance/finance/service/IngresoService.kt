package com.finance.finance.service

import com.finance.finance.generics.GenericService
import com.finance.finance.generics.GenericServiceImpl
import com.finance.finance.repository.IngresoRepository
import org.springframework.stereotype.Service
import com.finance.finance.model.Ingreso

@Service
class IngresoService(repository: IngresoRepository) : GenericServiceImpl<Ingreso, Long>(repository),
    GenericService<Ingreso, Long>