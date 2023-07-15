package com.example.pipefywebhook.service

import com.example.pipefywebhook.model.CardDBO
import com.example.pipefywebhook.repository.LogRepository
import org.springframework.stereotype.Service

@Service
class LogService(
    private val logRepository: LogRepository
) {
    fun saveLog(cardDBO: CardDBO) = logRepository.save(cardDBO)
}