package com.finance.finance.auth.request

data class LoginRequest(
    val email: String,
    val password: String
)