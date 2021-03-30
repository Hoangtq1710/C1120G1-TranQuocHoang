package com.soren.repository;

import com.soren.model.Login;
import com.soren.model.User;

public interface UserRepository {

    User checkLogin(Login login);
}
