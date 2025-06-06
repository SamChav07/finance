package com.finance.finance.controller

import com.finance.finance.DTOs.request.UsuarioRequestDTO
import com.finance.finance.DTOs.response.UsuarioResponseDTO
import com.finance.finance.generics.GenericDTOController
import com.finance.finance.model.Usuario
import com.finance.finance.service.UsuarioService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(service: UsuarioService) :
    GenericDTOController<Usuario, Long, UsuarioRequestDTO, UsuarioResponseDTO>(service)