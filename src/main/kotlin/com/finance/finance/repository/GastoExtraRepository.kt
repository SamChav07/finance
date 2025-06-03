package com.finance.finance.repository

import com.finance.finance.generics.GenericRepository
import com.finance.finance.model.GastoExtra
import org.springframework.stereotype.Repository

@Repository
interface GastoExtraRepository : GenericRepository<GastoExtra, Long>