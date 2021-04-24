package com.soren.service.impl;

import com.soren.model.Employee;
import com.soren.model.User;
import com.soren.repository.EmployeeRepository;
import com.soren.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Employee> findAllList() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee findByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public void save(Employee employee) {
        if (employee.getEmployeeId() == null) {
            String strPw = employee.getUser().getPassword();
            String bCryptPw = BCrypt.hashpw(strPw, BCrypt.gensalt());
            employee.getUser().setPassword(bCryptPw);
        }
        repository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
