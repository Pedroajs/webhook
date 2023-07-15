package com.example.pipefywebhook.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class CardDBO(
    @Id
    val id: UUID,
    val name: String,
    val email: String,
    val occupation: String,
)