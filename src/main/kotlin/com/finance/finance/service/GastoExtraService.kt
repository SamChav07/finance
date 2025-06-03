package com.finance.finance.service

import com.finance.finance.generics.GenericService
import com.finance.finance.generics.GenericServiceImpl
import com.finance.finance.repository.GastoExtraRepository
import org.springframework.stereotype.Service
import com.finance.finance.model.GastoExtra

@Service
class GastoExtraService(repository: GastoExtraRepository) : GenericServiceImpl<GastoExtra, Long>(repository),
    GenericService<GastoExtra, Long>