package com.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class IntegrationTest(@Autowired val client: WebTestClient) {

	@Test
	fun `test foo controller`() {
		client.get().uri("/controller/foo").exchange()
				.expectStatus().isOk
				.expectBody<String>().isEqualTo("foo")
	}

	@Test
	fun `test foo router`() {
		client.get().uri("/router/foo").exchange()
				.expectStatus().isOk
				.expectBody<String>().isEqualTo("foo")
	}
}