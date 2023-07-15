package com.example.pipefywebhook

import com.example.pipefywebhook.model.CardDBO
import com.example.pipefywebhook.model.CardDTO
import com.example.pipefywebhook.repository.LogRepository
import com.example.pipefywebhook.service.LogService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.UUID

@SpringBootTest
class PipefywebhookApplicationTests{
	@Autowired
	lateinit var logService: LogService
	@Test
	fun contextLoads() {
	}

	@Test
	fun `should save a log when requested`(){
		val cardDTO = CardDTO(id = null,
			name = "Pedro",
			email ="pedroajs@gmail.com",
			occupation = "Desenvolvedor")
			.toDBO()
		val cardLogSaved = logService.saveLog(cardDTO)
		Assertions.assertEquals(cardDTO.id, cardLogSaved.id)
	}
}
