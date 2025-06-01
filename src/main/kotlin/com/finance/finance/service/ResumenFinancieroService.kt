package com.finance.finance.service

import com.finance.finance.repository.ResumenFinancieroRepository
import org.springframework.stereotype.Service
import com.finance.finance.model.ResumenFinanciero

@Service
class ResumenFinancieroService(repository: ResumenFinancieroRepository) : GenericServiceImpl<ResumenFinanciero, Long>(repository), GenericService<ResumenFinanciero, Long>