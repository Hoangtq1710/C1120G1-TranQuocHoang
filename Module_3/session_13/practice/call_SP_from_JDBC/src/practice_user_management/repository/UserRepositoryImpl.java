package practice_user_management.repository;

import practice_user_management.model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String SELECT_ALL_USERS = "select * from users;";
    public static final String INSERT_NEW_USER = "insert into users(`name`, email, country) values (?, ?, ?);";
    public static final String SELECT_USER_BY_ID = "select * from users where id = ?;";
    public static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    public static final String UPDATE_USERS_SQL = "update users set `name` = ?,email = ?, country = ? where id = ?;";
    public static final String SEARCH_USERS_SQL = "select * from users where country like ?;";
    public static final String SORT_BY_NAME_DESC = "select * from users order by `name` desc;";
    public static final String SORT_BY_NAME_ASC = "select * from users order by `name`;";
    public static final String CALL_GET_USER_BY_ID = "call get_user_by_id( ? );";
    public static final String CALL_INSERT_USER = "call insert_user(?, ? ,?);";
    public static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    public static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    public static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    public static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";
    public static final String CALL_FIND_ALL_USER = "call find_all_user()";
    public static final String CALL_UPDATE_USER = "call update_user(?, ?, ?, ?);";
    public static final String CALL_DELETE_USER = "call delete_user( ? );";

    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_USER);

                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());


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
    public User selectUser(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_USER_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
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
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USERS);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE_USERS_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(UPDATE_USERS_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchUser(String searchCountry) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_USERS_SQL);
                statement.setString(1, "%" + searchCountry + "%");
                resultSet = statement.executeQuery();


                User user;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public List<User> sortListUser(String sortBy) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        User user;

        if (connection != null) {
            try {
                if (sortBy.equals("desc")) {
                    statement = connection.prepareStatement(SORT_BY_NAME_DESC);
                } else {
                    statement = connection.prepareStatement(SORT_BY_NAME_ASC);
                }
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }




    @Override
    public User getUserById(int id) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            try {
                statement = connection.prepareCall(CALL_GET_USER_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
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
        return user;
    }

    @Override
    public void insertUserSP(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareCall(CALL_INSERT_USER);

                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());


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
    public void addUserTransaction(User user, int[] permission) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        PreparedStatement statementAssignment = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());

                int rowAffected = statement.executeUpdate();

                resultSet = statement.getGeneratedKeys();
                int userId = 0;
                if (resultSet.next()) {
                    userId = resultSet.getInt(1);
                }

                if (rowAffected == 1) {
                    statementAssignment = connection.prepareStatement("insert into user_permision(permision_id, user_id) values (?, ?)");
                    for (int permissionId : permission) {
                        statementAssignment.setInt(1, permissionId);
                        statementAssignment.setInt(2, userId);
                        statementAssignment.executeUpdate();
                    }
                    connection.commit();
                } else {
                    connection.rollback();
                }
                try {
                    if (connection != null) {
                        connection.rollback();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    statementAssignment.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        PreparedStatement prepareInsert = null;
        PreparedStatement prepareUpdate = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                prepareInsert = connection.prepareStatement(SQL_INSERT);
                prepareUpdate = connection.prepareStatement(SQL_UPDATE);

                statement.execute(SQL_TABLE_DROP);
                statement.execute(SQL_TABLE_CREATE);

                prepareInsert.setString(1,"Quynh");
                prepareInsert.setBigDecimal(2, new BigDecimal(10));
                prepareInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                prepareInsert.execute();

                prepareInsert.setString(1,"Ngan");
                prepareInsert.setBigDecimal(2, new BigDecimal(20));
                prepareInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                prepareInsert.execute();

                prepareUpdate.setBigDecimal(2, new BigDecimal(999.99));

                prepareUpdate.setString(2,"Quynh");
                prepareUpdate.execute();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    prepareUpdate.close();
                    prepareInsert.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        Connection connection = DBConnection.getConnection();
        Statement statement = null;
        PreparedStatement prepareInsert = null;
        PreparedStatement prepareUpdate = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                prepareInsert = connection.prepareStatement(SQL_INSERT);
                prepareUpdate = connection.prepareStatement(SQL_UPDATE);

                statement.execute(SQL_TABLE_DROP);
                statement.execute(SQL_TABLE_CREATE);

                connection.setAutoCommit(false);

                prepareInsert.setString(1,"Quynh");
                prepareInsert.setBigDecimal(2, new BigDecimal(10));
                prepareInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                prepareInsert.execute();

                prepareInsert.setString(1,"Ngan");
                prepareInsert.setBigDecimal(2, new BigDecimal(20));
                prepareInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                prepareInsert.execute();

                prepareUpdate.setBigDecimal(2, new BigDecimal(999.99));
                prepareUpdate.setBigDecimal(1, new BigDecimal(999.99));

                prepareUpdate.setString(2,"Quynh");
                prepareUpdate.execute();

                connection.commit();

                connection.setAutoCommit(true);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    prepareUpdate.close();
                    prepareInsert.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<User> findAllUser() {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareCall(CALL_FIND_ALL_USER);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public boolean updateUserSP(User user) {
        boolean rowUpdated = false;
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;

        try {
            statement = connection.prepareCall(CALL_UPDATE_USER);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getCountry());


            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
        return rowUpdated;

    }

    @Override
    public boolean deleteUserSP(int id) {
        boolean rowDeleted = false;
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(CALL_DELETE_USER);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DBConnection.close();
        }
        return rowDeleted;
    }
}
