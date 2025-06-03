package com.finance.finance.generics

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface GenericRepository<T : GenericEntity, ID : Any> : JpaRepository<T, ID>