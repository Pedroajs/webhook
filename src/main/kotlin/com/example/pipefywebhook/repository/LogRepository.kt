package com.example.pipefywebhook.repository

import com.example.pipefywebhook.model.CardDBO
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface LogRepository : JpaRepository<CardDBO, UUID> {
}