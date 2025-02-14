package com.abhisheklodha.Employee_management;

import java.util.List;

public interface EmpService {
    String createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    String deleteEmployee(Long id);
}
