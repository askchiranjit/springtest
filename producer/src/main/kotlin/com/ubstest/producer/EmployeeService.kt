package com.ubstest.producer

import org.springframework.stereotype.Service

@Service
class EmployeeService {

    public fun getEmployee(): Employee {
        return Employee()
    }
}