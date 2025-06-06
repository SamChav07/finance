package com.finance.finance.exception

class ValidationException(
    override val message: String
) : BusinessException(message, 422)
