package com.careerdrill.radis;

import com.careerdrill.radis.entity.Employee;
import com.careerdrill.radis.publish.EmployeePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeePublisher publisher;


    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        try {
            publisher.publish(employee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @GetMapping
    public Employee findAll() {
        Employee employee = new Employee();
        employee.setFirstname("siva");
        employee.setLastname("selvi");
        employee.setEmpID(11);
        employee.setAge(23);
        return employee;
    }


}