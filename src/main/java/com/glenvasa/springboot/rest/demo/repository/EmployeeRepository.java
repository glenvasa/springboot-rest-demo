package com.glenvasa.springboot.rest.demo.repository;

import com.glenvasa.springboot.rest.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// We don't need @Repository annotation b/c Spring Data JPA internally provides it
// Also Spring Data JPA makes JpaRepository methods transactional so we don't need to add @Transactional in Service class
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
