package com.soren.service;

import com.soren.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User createUserByUsername(String username);
}
