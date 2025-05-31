package com.finance.finance.repository

import com.finance.finance.model.User

interface UserRepository : GenericRepository<User, Long> {
    fun findByEmail(email: String): User?
}