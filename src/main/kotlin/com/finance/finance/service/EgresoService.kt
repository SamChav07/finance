package com.finance.finance.service

import com.finance.finance.repository.EgresoRepository
import org.springframework.stereotype.Service
import com.finance.finance.model.Egreso

@Service
class EgresoService(repository: EgresoRepository) : GenericServiceImpl<Egreso, Long>(repository), GenericService<Egreso, Long>