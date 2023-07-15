package com.example.pipefywebhook.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class CardDBO(
    @Id
    @GeneratedValue
    val id: UUID?,
    val name: String,
    val email: String,
    val occupation: String,
){
    fun toModel() = id?.let {
        Card(
        id = it,
        name = name,
        email = email,
        occupation = occupation,
    )
    }
}