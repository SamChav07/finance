package com.finance.finance.repository

import com.finance.finance.model.GenericEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface GenericRepository<T : GenericEntity, ID : Any> : JpaRepository<T, ID>
// con ID:Any sugiere el uso del non-nullableID