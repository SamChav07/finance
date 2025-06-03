package com.finance.finance.repository

import com.finance.finance.generics.GenericRepository
import com.finance.finance.model.Ingreso
import org.springframework.stereotype.Repository

@Repository
interface IngresoRepository : GenericRepository<Ingreso, Long>