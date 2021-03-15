package practice_user_management.repository;

import practice_user_management.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
