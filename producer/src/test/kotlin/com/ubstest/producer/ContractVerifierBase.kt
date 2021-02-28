package com.ubstest.producer

import io.restassured.RestAssured
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContractVerifierBase {

    @Autowired lateinit var employeeController: EmployeeController
    @MockBean lateinit var employeeService: EmployeeService

    @BeforeAll
    public fun before() {
        var employee = Employee(1, "Jane")
        Mockito.`when`(employeeService.getEmployee()).thenReturn(employee)
        RestAssuredMockMvc.standaloneSetup(employeeController)
    }
}