package com.soren.service.impl;

import com.soren.model.User;
import com.soren.repository.UserRepository;
import com.soren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<User> list = findAll();
        for(User user : list){
            if (user.getUsername().equals(username)) {
                return null;
            }
        }
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
}
