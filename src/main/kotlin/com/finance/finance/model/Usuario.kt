package com.finance.finance.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "usuario")
data class Usuario(
    var nombre: String,
    var email: String,
    var frecuenciaIngreso: String,
    var montoIngreso: Int,

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    var ingresos: List<Ingreso> = emptyList(),

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    var egresos: List<Egreso> = emptyList(),

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    var planesAhorro: List<PlanAhorro> = emptyList(),

    @OneToOne(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    var resumenFinanciero: ResumenFinanciero? = null
) : GenericEntity()
