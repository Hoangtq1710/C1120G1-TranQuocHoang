package com.soren.service.impl;

import com.soren.model.User;
import com.soren.repository.UserRepository;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User createUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(username);
        user.setEnabled(true);

        save(user);
        return user;
    }

    @Override
    public void changePassword(User user, String newPassword) {
        if (!user.getPassword().equals(newPassword)) {
            user.setPassword(newPassword);
        }
        save(user);
    }

    @Override
    public void checkUsernameExist(String username, Errors errors) {
        for(User u : findAll()){
            if (u.getUsername().equals(username)) {
                errors.rejectValue("user", "emp.username.existed");
                return;
            }
        }
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}