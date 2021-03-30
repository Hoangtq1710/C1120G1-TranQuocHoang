package com.soren.repository.impl;

import com.soren.model.Login;
import com.soren.model.User;
import com.soren.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    static List<User> listUser;

    static {
         listUser = new ArrayList<>();
         listUser.add(new User("Hoang",26,"hoang@gmail.com", "hoang", "hoang"));
         listUser.add(new User("Vi",29,"vi.36@gmail.com", "vi", "vi"));
         listUser.add(new User("Quang",28,"quang@gmail.com", "quang", "quang"));
         listUser.add(new User("Thuan",23,"thuan@gmail.com", "thuan", "thuan"));
         listUser.add(new User("Ngoc",24,"ngoc@gmail.com", "ngoc", "ngoc"));
         listUser.add(new User("Sang",25,"sang@gmail.com", "sang", "sang"));
    }

    @Override
    public User checkLogin(Login login) {
        for(User user : listUser) {
            if ((user.getUsername().equals(login.getUsername())) && (user.getPassword().equals(login.getPassword()))){
                return user;
            }
        }
        return null;
    }
}
