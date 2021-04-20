package com.soren.service;

import com.soren.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAllList();

    Employee findById(Integer id);

    void save(Employee employee);

    void deleteById(Integer id);
}
