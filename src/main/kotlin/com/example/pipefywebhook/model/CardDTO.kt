package com.example.pipefywebhook.model

import java.util.UUID

data class CardDTO(
    val id: UUID?,
    val name: String,
    val email: String,
    val occupation: String,
) {
    fun toDBO() = CardDBO(
        id = id,
        name = name,
        email = email,
        occupation =occupation,
    )

    fun toModel() = Card(
        name = name,
        email = email,
        occupation = occupation,
    )
}