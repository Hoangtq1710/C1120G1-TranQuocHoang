package service.user;

import model.User;

public interface UserService {
    void createAccount(String username);

    User findByUserName(String username);

    void update(String username, String password);
}
