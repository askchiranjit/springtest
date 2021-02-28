package com.ubstest.producer

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController {

    @Autowired lateinit var employeeService: EmployeeService

    @GetMapping("/employee")
    public fun getEmployee(): ResponseEntity<Any> {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeService.getEmployee());
    }

}