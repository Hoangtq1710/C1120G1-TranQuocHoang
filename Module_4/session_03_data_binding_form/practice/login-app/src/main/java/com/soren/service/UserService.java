package com.soren.service;

import com.soren.model.Login;
import com.soren.model.User;

public interface UserService {
    User checkLogin(Login login);
}
