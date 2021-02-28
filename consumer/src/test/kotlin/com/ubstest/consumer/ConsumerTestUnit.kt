package com.ubstest.consumer

import com.github.tomakehurst.wiremock.client.WireMock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import wiremock.com.fasterxml.jackson.databind.ObjectMapper


@SpringBootTest
@AutoConfigureWireMock(port = 8080)
@AutoConfigureJson
class ConsumerTestUnit {

    @Autowired lateinit var consumerClient: ConsumerClient

    @Test
    public fun clientShouldReturnEmployee() {
        WireMock.stubFor(WireMock
                .get(WireMock.urlEqualTo("/employee/"))
                .willReturn(
                        WireMock.aResponse()
                                .withStatus(200)
                                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .withBody(jsonForPerson(Person(1, "DAF")))))


        Assertions.assertEquals("DAF", consumerClient.getPerson()!!.name)
    }

    private fun jsonForPerson(person: Person) : String {
        var objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(person)
    }
}