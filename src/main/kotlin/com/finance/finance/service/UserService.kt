package com.finance.finance.service

import com.finance.finance.repository.UsuarioRepository
import org.springframework.stereotype.Service
import com.finance.finance.model.Usuario

@Service
class UsuarioService(repository: UsuarioRepository) : GenericServiceImpl<Usuario, Long>(repository), GenericService<Usuario, Long>