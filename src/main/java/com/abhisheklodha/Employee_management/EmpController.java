package com.abhisheklodha.Employee_management;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @PostMapping("/create-employee")
    public String createEmployee(@RequestBody Employee employee) {
        empService.createEmployee(employee);
        return "Employee created successfully";
    }

    @GetMapping("/get-employees")
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return empService.deleteEmployee(id);
    }

    @PutMapping("update-employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return empService.updateEmployee(employee);
    }

}
