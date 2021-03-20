package repository.division;

import model.Division;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRepositoryImpl implements DivisionRepository{
    public static final String SELECT_DIV_BY_ID = "select * from division where division_id = ?;";

    @Override
    public Division findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Division division = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_DIV_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString("division_name");
                    division = new Division(id, name);
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
        return division;
    }
}
