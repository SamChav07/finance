package com.finance.finance.auth.request

data class RegisterRequest(
    val nombre: String,
    val email: String,
    val password: String,
    val frecuenciaIngreso: String,
    val montoIngreso: Int
)
