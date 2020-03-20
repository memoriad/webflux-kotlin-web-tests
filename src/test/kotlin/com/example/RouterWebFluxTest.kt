package com.example

import com.ninjasquad.springmockk.MockkBean
import io.mockk.coEvery
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@WebFluxTest(RouterConfiguration::class)
class RouterWebFluxTest {

    @Autowired
    private lateinit var client: WebTestClient

    @MockkBean
    private lateinit var fooHandler: FooHandler

    @Test
    fun `test foo`() {
        coEvery { fooHandler.foo(any()) } coAnswers {
            ServerResponse
                .ok()
                .json()
                .bodyValueAndAwait(
                    "foo"
                )
        }
        client.get()
            .uri("/router/foo")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("foo")
    }
}