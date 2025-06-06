package com.finance.finance.model

import com.finance.finance.generics.GenericEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "usuario")
data class Usuario(
    var nombre: String,
    var email: String,
    var clave: String, // 👈 importante: NO cambiar a "clave"
    var frecuenciaIngreso: String,
    var montoIngreso: Int,

    // relaciones omitidas para claridad...
) : GenericEntity(), UserDetails {

    override fun getUsername(): String = email
    override fun getPassword(): String? = clave// ✅ requerido por Spring Security
    override fun getAuthorities() = emptyList<GrantedAuthority>()
    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true

    // Constructor secundario para crear Usuario solo con id
    constructor(id: Long) : this(
        nombre = "",
        email = "",
        clave = "",
        frecuenciaIngreso = "",
        montoIngreso = 0
    ) {
        this.id = id
    }
}