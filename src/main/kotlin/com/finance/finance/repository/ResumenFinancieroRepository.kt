package com.finance.finance.repository

import com.finance.finance.generics.GenericRepository
import com.finance.finance.model.ResumenFinanciero
import org.springframework.stereotype.Repository

@Repository
interface ResumenFinancieroRepository : GenericRepository<ResumenFinanciero, Long>
