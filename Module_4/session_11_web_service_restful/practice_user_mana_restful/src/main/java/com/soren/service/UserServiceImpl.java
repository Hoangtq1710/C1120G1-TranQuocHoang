package com.soren.service;

import com.soren.model.User;
import com.soren.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    UserRepository repository;


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
