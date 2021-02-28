package com.ubstest.consumer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureStubRunner(ids = arrayOf("com.ubstest:producer:+:stubs:8080"), stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@AutoConfigureMockMvc
class ConsumerTestContract {

    @Autowired lateinit var consumerClient: ConsumerClient

    @Test
    public fun clientShouldPrintName() {
        Assertions.assertEquals("Jane", consumerClient.getPerson()!!.name)
    }
}