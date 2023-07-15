package com.example.pipefywebhook.controller

import com.example.pipefywebhook.model.Card
import com.example.pipefywebhook.model.CardDTO
import com.example.pipefywebhook.service.LogService
import com.example.pipefywebhook.utils.logger
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
@Slf4j
class WebhookController(
    private val logService: LogService
) {

    @PostMapping
    fun loggingCardMovedInfo(@RequestBody cardDTO: CardDTO) : ResponseEntity<Card>{
      return try {
            val dbo = cardDTO.toDBO()
            logService.saveLog(dbo)
            logger().info("${cardDTO.name} ${cardDTO.email} ${cardDTO.occupation}")
            ResponseEntity(dbo.toModel(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }
}
