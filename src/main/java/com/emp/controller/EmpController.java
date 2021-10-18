package com.emp.controller;

import com.emp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${uri_emp_mgm}")
    String URI_USERS_ID;
    @GetMapping(value = "/findEmpId")
    public Employee findById(int id){
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        Employee employee = restTemplate.getForObject(URI_USERS_ID, Employee.class, params);
        return employee;
    }
}
