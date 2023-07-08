package com.example.pipefywebhook

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
class WebhookController {

    @PostMapping
    fun loggingCardMovedInfo(@RequestBody card: Card) : ResponseEntity<Card>{
        println("logging ${card.email}, ${card.name}, ${card.occupation}")
        return ResponseEntity(card,HttpStatus.OK)
    }
}

data class Card(
    val name: String,
    val email: String,
    val occupation: String,
)