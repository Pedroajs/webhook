package com.example.pipefywebhook

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
class WebhookController() {

    @PostMapping
    fun loggingCardMovedInfo(@RequestBody card: Card) : ResponseEntity<Card>{
        try {
            logger().info("${card.name} ${card.email} ${card.occupation}")
        } catch (e: Exception) { throw e }
        return ResponseEntity(card, HttpStatus.OK)
    }
}
