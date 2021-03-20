package repository.position;

import model.Position;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRepositoryImpl implements PositionRepository{
    public static final String SELECT_POS_BY_ID = "select * from `position` where position_id = ?;";

    @Override
    public Position findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Position position = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_POS_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString("position_name");
                    position = new Position(id, name);
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
        return position;
    }
}
