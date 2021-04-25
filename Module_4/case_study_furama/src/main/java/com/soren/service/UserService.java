package com.soren.service;

import com.soren.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User createUserByUsername(String username);

    void changePassword(User user, String newPassword);

    void validateUsernameExist(String username, Errors errors);

    User findByUsername(String username);

}
