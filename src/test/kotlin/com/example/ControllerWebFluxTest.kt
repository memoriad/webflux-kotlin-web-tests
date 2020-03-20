package com.example

import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebFluxTest
class ControllerWebFluxTest(@Autowired val client: WebTestClient) {

    @MockkBean
    private lateinit var fooService: FooService

    @Test
    fun `test foo`() {
        coEvery { fooService.foo() } coAnswers { "foo" }
        client.get().uri("/controller/foo").exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("foo")
    }
}