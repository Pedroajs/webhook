package com.example.pipefywebhook

import com.example.pipefywebhook.model.CardDBO
import com.example.pipefywebhook.repository.LogRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest
class PipefywebhookApplicationTests{

	@Autowired
	lateinit var logRepository: LogRepository
	@Test
	fun contextLoads() {
	}


	@Test
	fun `should save a log when requested`(){
		val id = UUID.randomUUID()
		val cardDBO = CardDBO(id,"Pedro", "pedroajs@gmail.com", "Desenvolvedor")
		val cardLogSaved = logRepository.save(cardDBO)
		Assertions.assertEquals(cardDBO.id, cardLogSaved.id)
	}
}
