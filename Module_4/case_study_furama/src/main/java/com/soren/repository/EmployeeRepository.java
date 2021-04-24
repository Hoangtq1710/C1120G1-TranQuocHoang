package com.soren.repository;

import com.soren.model.Employee;
import com.soren.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUser(User user);
}
