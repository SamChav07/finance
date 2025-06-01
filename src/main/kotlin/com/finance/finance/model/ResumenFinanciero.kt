package com.finance.finance.model

import jakarta.persistence.Entity
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

    @OneToOne
    @JoinColumn(name = "usuario_id")
    var usuario: Usuario
) : GenericEntity()
