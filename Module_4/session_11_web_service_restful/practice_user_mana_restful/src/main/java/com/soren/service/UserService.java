package com.soren.service;

import com.soren.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void deleteById(Integer id);
}
