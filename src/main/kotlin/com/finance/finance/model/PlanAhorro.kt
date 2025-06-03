package com.finance.finance.model

import com.finance.finance.generics.GenericEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "plan_ahorro")
data class PlanAhorro(
    var nombre: String,
    var descripcionMeta: String,
    var fechaInicio: String,
    var montoMeta: Int,
    var montoAhorrado: Int,
    var plazoMeses: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    var usuario: Usuario
) : GenericEntity()