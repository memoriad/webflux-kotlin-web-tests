package com.example

import io.mockk.coEvery
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

class RouterMockedTest {

    @Test
    fun `test foo`() {
        val fooHandler = mockk<FooHandler>()
        coEvery { fooHandler.foo(any()) } coAnswers {
            ServerResponse
                .ok()
                .json()
                .bodyValueAndAwait(
                    "foo"
                )
        }
        val router = RouterConfiguration().router(fooHandler)
        val client = WebTestClient.bindToRouterFunction(router).build()
        client.get()
            .uri("/router/foo")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("foo")
    }
}