package com.finance.finance.exception

class NotFoundException(
    resource: String,
    id: Any
) : BusinessException("$resource con ID '$id' no fue encontrado", 404)
