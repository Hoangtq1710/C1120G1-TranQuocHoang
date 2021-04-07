package com.soren.service;

import com.soren.model.User;
import com.soren.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
