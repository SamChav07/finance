package com.finance.finance.repository

import com.finance.finance.generics.GenericRepository
import com.finance.finance.model.PlanAhorro
import org.springframework.stereotype.Repository

@Repository
interface PlanAhorroRepository : GenericRepository<PlanAhorro, Long>