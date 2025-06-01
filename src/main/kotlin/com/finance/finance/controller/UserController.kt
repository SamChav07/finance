package com.finance.finance.controller

import com.finance.finance.model.Usuario
import com.finance.finance.service.GenericService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/usuarios")
class UsuarioController(service: GenericService<Usuario, Long>) : GenericController<Usuario, Long>(service)