package com.finance.finance.exception.handler

import com.finance.finance.exception.*
import com.finance.finance.exception.response.ApiErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(
        ex: BusinessException,
        request: HttpServletRequest
    ): ResponseEntity<ApiErrorResponse> {
        val error = ApiErrorResponse(
            status = ex.code,
            error = HttpStatus.valueOf(ex.code).reasonPhrase,
            message = ex.message ?: "Error de negocio",
            path = request.requestURI
        )
        return ResponseEntity.status(ex.code).body(error)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(
        ex: Exception,
        request: HttpServletRequest
    ): ResponseEntity<ApiErrorResponse> {
        val error = ApiErrorResponse(
            status = 500,
            error = "Error interno",
            message = ex.message ?: "Error desconocido",
            path = request.requestURI
        )
        return ResponseEntity.status(500).body(error)
    }
}