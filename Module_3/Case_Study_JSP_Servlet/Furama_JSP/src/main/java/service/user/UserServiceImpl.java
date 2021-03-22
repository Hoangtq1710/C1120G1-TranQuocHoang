package service.user;

import model.User;
import repository.user.UserRepository;
import repository.user.UserRepositoryImpl;

import java.util.TreeMap;

public class UserServiceImpl implements UserService{
    UserRepository repository = new UserRepositoryImpl();
    @Override
    public void createAccount(String username) {
        repository.createAccount(username);
    }

    @Override
    public User findByUserName(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public void update(String username, String password) {
        repository.update(username, password);
    }

    @Override
    public TreeMap<String, String> getMapAccount() {
        return repository.getMapAccount();
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return repository.checkLogin(username, password);
    }

    @Override
    public String getUserNameOnLogin(String username) {
        return repository.getUserNameOnLogin(username);
    }
}
