package repository.user;

import model.User;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

public class UserRepositoryImpl implements UserRepository{
    public static final String CREATE_NEW_ACC = "insert into `user`(`username`, `password`) values (?, ?);";
    public static final String FIND_BY_USERNAME = "select * from `user` where `username` = ?;";
    public static final String UPDATE_ACC = "update `user` set `password` = ? where `username` = ?;";
    public static final String GET_NAME_EMP_BY_USERNAME =   "select employee_name from employee " +
                                                            "inner join `user` on `user`.username = employee.username " +
                                                            "where `user`.username = ?;";

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

    @Override
    public TreeMap<String, String> getMapAccount(){
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        TreeMap<String, String> mapLogin = new TreeMap<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from `user`;");
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");

                    mapLogin.put(username, password);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return mapLogin;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        TreeMap<String, String> mapLogin = getMapAccount();
        if (mapLogin.containsKey(username) && (mapLogin.get(username).equals(password))) {
            return true;
        }
        return false;
    }

    @Override
    public String getUserNameOnLogin(String username) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String employeeName = "";

        if (connection != null) {
            try {
                statement = connection.prepareStatement(GET_NAME_EMP_BY_USERNAME);
                statement.setString(1, username);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    employeeName = resultSet.getString("employee_name");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return employeeName;
    }
}
