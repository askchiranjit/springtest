package com.ubstest.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ConsumerApplication

fun main(args: Array<String>) {
	runApplication<ConsumerApplication>(*args)
}

@Component
class ConsumerClient {

	public fun getPerson() : Person? {
		var restTemplate = RestTemplate()
		var result: ResponseEntity<Person> = restTemplate
				.exchange("http://localhost:8080/employee/",
						HttpMethod.GET,
						null,
						Person::class.java)
		return result.body
	}
}

@EntityScan
data class Person(var id: Int, var name: String) {
}