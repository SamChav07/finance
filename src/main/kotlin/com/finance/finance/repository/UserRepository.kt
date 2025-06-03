package com.finance.finance.repository

import com.finance.finance.generics.GenericRepository
import com.finance.finance.model.Usuario
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : GenericRepository<Usuario, Long>