package com.finance.finance.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table(name = "egreso")
data class Egreso(
    var categoria: String,
    var subcategoria: String,
    var descripcion: String,
    var fecha: String,
    var monto: Int,

    @Enumerated(EnumType.STRING)
    var tipo: TipoEgreso,

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    var usuario: Usuario
) : GenericEntity()
