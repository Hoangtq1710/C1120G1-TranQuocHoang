package service.user;

import model.User;

import java.util.TreeMap;

public interface UserService {
    void createAccount(String username);

    User findByUserName(String username);

    void update(String username, String password);

    TreeMap<String, String> getMapAccount();

    boolean checkLogin(String username, String password);

    String getUserNameOnLogin(String username);
}
