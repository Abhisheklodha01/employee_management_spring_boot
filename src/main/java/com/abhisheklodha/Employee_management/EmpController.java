package com.abhisheklodha.Employee_management;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EmpController {
    @GetMapping("/employees")
    public static List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        return employees;
    }
    
}
