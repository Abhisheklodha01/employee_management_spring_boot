package com.abhisheklodha.Employee_management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImplement implements EmpService {
    @Autowired
    private EmpRepository empRepository;
    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee, empEntity);
        empRepository.save(empEntity);
        return "Employee created successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmpEntity> employeesList = empRepository.findAll();
        for (EmpEntity empEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(empEntity.getId());
            emp.setName(empEntity.getName());
            emp.setPhoneNumber(empEntity.getPhoneNumber());
            emp.setEmail(empEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EmpEntity empEntity = empRepository.findById(employee.getId()).orElse(null);
        if (empEntity == null) {
            return null;
        }
        BeanUtils.copyProperties(employee, empEntity);
        empRepository.save(empEntity);
        Employee updatedEmployee = new Employee();
        BeanUtils.copyProperties(empEntity, updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public String deleteEmployee(Long id) {
        EmpEntity empEntity = empRepository.findById(id).orElse(null);
        if (empEntity == null) {
            return "Employee not found";
        }
        empRepository.delete(empEntity);
        return "Employee deleted successfully";
    }

}
