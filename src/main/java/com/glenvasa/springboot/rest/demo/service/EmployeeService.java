package com.glenvasa.springboot.rest.demo.service;

import com.glenvasa.springboot.rest.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();

}
