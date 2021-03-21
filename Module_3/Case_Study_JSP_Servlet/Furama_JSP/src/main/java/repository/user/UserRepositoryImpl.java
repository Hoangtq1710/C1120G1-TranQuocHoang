package repository.user;

import model.User;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository{
    public static final String CREATE_NEW_ACC = "insert into `user`(`username`, `password`) values (?, ?);";
    public static final String FIND_BY_USERNAME = "select * from `user` where `username` = ?;";
    public static final String UPDATE_ACC = "update `user` set `password` = ? where `username` = ?;";

    @Override
    public void createAccount(String username) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        // mặc định ban đầu password = username
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CREATE_NEW_ACC);
                statement.setString(1, username);
                statement.setString(2, username);

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public User findByUserName(String username) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_BY_USERNAME);
                statement.setString(1, username);

                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String password = resultSet.getString("password");
                    user = new User(username, password);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return user;
    }

    @Override
    public void update(String username, String password) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_ACC);
                statement.setString(1, password);
                statement.setString(2, username);

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }
}
