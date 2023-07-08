package com.example.pipefywebhook

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
class WebhookController : LoggerUtil() {

    @PostMapping
    fun loggingCardMovedInfo(@RequestBody card: Card) : ResponseEntity<Any>{
        log("Nome:${card.name} Email:${card.email} Ocupação:${card.occupation}")
        return ResponseEntity.ok().build()
    }
}

data class Card(
    val name: String,
    val email: String,
    val occupation: String,
)