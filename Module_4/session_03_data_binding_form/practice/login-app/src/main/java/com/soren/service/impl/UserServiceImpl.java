package com.soren.service.impl;

import com.soren.model.Login;
import com.soren.model.User;
import com.soren.repository.UserRepository;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User checkLogin(Login login) {
        return repository.checkLogin(login);
    }
}
