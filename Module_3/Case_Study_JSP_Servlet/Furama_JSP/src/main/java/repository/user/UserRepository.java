package repository.user;

import model.User;

public interface UserRepository {
    void createAccount(String username);

    User findByUserName(String username);
}
