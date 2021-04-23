package com.soren.service;

import com.soren.model.Employee;
import com.soren.model.User;
import com.soren.model.UserRole;

public interface UserRoleService {

    void save(UserRole userRole);

    void createUserRole(User user, Employee employee);
}
