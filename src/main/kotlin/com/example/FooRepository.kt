package com.example

import org.springframework.stereotype.Repository

@Repository
class FooRepository {

    suspend fun foo() = "foo"
}