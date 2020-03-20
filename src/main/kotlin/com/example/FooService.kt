package com.example

import org.springframework.stereotype.Service

@Service
class FooService(
    private val fooRepository: FooRepository
) {
    suspend fun foo() = fooRepository.foo()
}