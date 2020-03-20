package com.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/controller")
class FooController(private val fooService: FooService) {

	@GetMapping("/foo")
	suspend fun foo() = fooService.foo()
}