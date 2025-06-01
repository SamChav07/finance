package com.finance.finance.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "ingreso")
data class Ingreso(
    var concepto: String,
    var fecha: LocalDate,
    var monto: Int,

    @Enumerated(EnumType.STRING)
    var fuente: TipoFuente,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    var usuario: Usuario
) : GenericEntity()