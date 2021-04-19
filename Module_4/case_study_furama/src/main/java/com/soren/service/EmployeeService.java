package com.soren.service;

import com.soren.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);
}
