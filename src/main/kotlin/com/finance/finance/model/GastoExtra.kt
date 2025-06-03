package com.finance.finance.model

import com.finance.finance.generics.GenericEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "gasto_extra")
data class GastoExtra(
    var motivo: String
) : GenericEntity()