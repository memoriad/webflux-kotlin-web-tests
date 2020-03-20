package com.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {

    @Bean
    fun router(fooHandler: FooHandler) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            "/router".nest {
                GET("/foo", fooHandler::foo)
            }
        }
    }
}