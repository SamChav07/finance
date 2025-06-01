package com.finance.finance.model

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "resumen_financiero")
data class ResumenFinanciero(
    var ahorroSugerido: Int,
    var egresosTotales: Int,
    var ingresosTotales: Int,
    var saldoDisponible: Int,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    var usuario: Usuario
) : GenericEntity()