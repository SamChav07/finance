package com.finance.finance.model

import com.finance.finance.generics.GenericEntity
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "egreso")
data class Egreso(
    var categoria: String,
    var subcategoria: String,
    var descripcion: String,
    var fecha: LocalDate,
    var monto: Int,

    @Enumerated(EnumType.STRING)
    var tipo: TipoEgreso,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    var usuario: Usuario
) : GenericEntity()