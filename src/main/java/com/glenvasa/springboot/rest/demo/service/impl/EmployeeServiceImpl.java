package com.glenvasa.springboot.rest.demo.service.impl;

import com.glenvasa.springboot.rest.demo.exception.ResourceNotFoundException;
import com.glenvasa.springboot.rest.demo.model.Employee;
import com.glenvasa.springboot.rest.demo.repository.EmployeeRepository;
import com.glenvasa.springboot.rest.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
// Don't need @Transactional b/c Spring JPA internally makes all Repository methods transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Don't need @Autowired annotation starting w/Spring 4.3 if the class only has 1 constructor.
    // Spring will use that constructor and inject all necessary dependencies
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new ResourceNotFoundException("Employee", "Id", id);
//        }

        // orElseThrow is the optional method if resource not found
        return employeeRepository.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Employee", "Id", id));


    }

}
