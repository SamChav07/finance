package com.finance.finance.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "user")
data class User(
    var name: String,
    var email: String
) : GenericEntity()