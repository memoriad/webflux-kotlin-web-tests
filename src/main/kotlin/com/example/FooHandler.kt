package com.example

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class FooHandler(
    private val fooService: FooService
) {
    suspend fun foo(request: ServerRequest): ServerResponse {
        return ServerResponse
            .ok()
            .json()
            .bodyValueAndAwait(
                fooService.foo()
            )
    }
}