package com.finance.finance.auth

import com.finance.finance.auth.request.LoginRequest
import com.finance.finance.auth.request.RegisterRequest
import com.finance.finance.auth.response.AuthResponse
import com.finance.finance.jwt.JwtService
import com.finance.finance.model.Usuario
import com.finance.finance.repository.UsuarioRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val usuarioRepository: UsuarioRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {

    fun register(request: RegisterRequest): AuthResponse {
        if (usuarioRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("El email ya está registrado")
        }

        val usuario = Usuario(
            nombre = request.nombre,
            email = request.email,
            clave = passwordEncoder.encode(request.password),
            frecuenciaIngreso = request.frecuenciaIngreso,
            montoIngreso = request.montoIngreso
        )

        usuarioRepository.save(usuario)
        val token = jwtService.generateToken(usuario)
        return AuthResponse(token)
    }

    fun login(request: LoginRequest): AuthResponse {
        val authToken = UsernamePasswordAuthenticationToken(request.email, request.password)
        authenticationManager.authenticate(authToken)

        val usuario = usuarioRepository.findByEmail(request.email)
            ?: throw IllegalArgumentException("Usuario no encontrado")

        val token = jwtService.generateToken(usuario)
        return AuthResponse(token)
    }
}