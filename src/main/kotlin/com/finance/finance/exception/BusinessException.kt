package com.finance.finance.exception

open class BusinessException(
    override val message: String,
    val code: Int = 400
) : RuntimeException(message)
