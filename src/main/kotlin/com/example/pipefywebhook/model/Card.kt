package com.example.pipefywebhook.model

import java.util.UUID

data class Card(
    val id: UUID,
    val name: String,
    val email: String,
    val occupation: String,
)