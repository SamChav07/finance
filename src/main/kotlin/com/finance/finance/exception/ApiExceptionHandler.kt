// ApiExceptionHandler.kt
package com.finance.finance.exception

import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

// Clase para el formato estándar de error
data class ErrorResponse(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String?
)

@ControllerAdvice
class GlobalExceptionHandler {

    // Manejo excepción personalizada NotFoundException
    @ExceptionHandler(ChangeSetPersister.NotFoundException::class)
    fun handleNotFoundException(ex: ChangeSetPersister.NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.reasonPhrase,
            message = ex.message,
            path = request.getDescription(false).removePrefix("uri=")
        )
        return ResponseEntity(errorResponse, HttpStatus.NOT_FOUND)
    }

    // Manejo excepción personalizada ConflictException
    @ExceptionHandler(ConflictException::class)
    fun handleConflictException(ex: ConflictException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.CONFLICT.value(),
            error = HttpStatus.CONFLICT.reasonPhrase,
            message = ex.message,
            path = request.getDescription(false).removePrefix("uri=")
        )
        return ResponseEntity(errorResponse, HttpStatus.CONFLICT)
    }

    // Manejo validaciones de @Valid en DTOs
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errors = ex.bindingResult.fieldErrors.joinToString(", ") { "${it.field}: ${it.defaultMessage}" }
        val errorResponse = ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            message = errors,
            path = request.getDescription(false).removePrefix("uri=")
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    // Manejo genérico para otras excepciones
    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
            message = ex.message ?: "Error inesperado",
            path = request.getDescription(false).removePrefix("uri=")
        )
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}