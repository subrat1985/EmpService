package com.emp.controller;

import com.emp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/Emp")
public class EmpController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping(value = "/findEmpId")
    public Employee findById(int id){
        final String URI_USERS_ID = "http://localhost:8080/employee/findId/{id}";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        Employee employee = restTemplate.getForObject(URI_USERS_ID, Employee.class, params);
        return employee;
    }
}
