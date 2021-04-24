package com.soren.service;

import com.soren.model.Employee;
import com.soren.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAllList();

    Employee findById(Integer id);

    Employee findByUser(User user);

    void save(Employee employee);

    void deleteById(Integer id);

    boolean checkPassword(String oldPw, Employee employee);
}
