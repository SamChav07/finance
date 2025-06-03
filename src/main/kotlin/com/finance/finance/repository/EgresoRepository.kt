package com.finance.finance.repository

import com.finance.finance.generics.GenericRepository
import com.finance.finance.model.Egreso
import org.springframework.stereotype.Repository

@Repository
interface EgresoRepository : GenericRepository<Egreso, Long>