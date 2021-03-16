package practice_user_management.service;

import practice_user_management.model.User;
import practice_user_management.repository.UserRepository;
import practice_user_management.repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    UserRepository repository = new UserRepositoryImpl();

    @Override
    public void insertUser(User user) throws SQLException {
        repository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return repository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return repository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return repository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return repository.updateUser(user);
    }

    @Override
    public List<User> searchUser(String country) {
        return repository.searchUser(country);
    }

    @Override
    public List<User> sortListUser(String sortBy) {
        return repository.sortListUser(sortBy);
    }
}
