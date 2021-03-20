package repository.rent_type;

import model.RentType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentTypeRepositoryImpl implements RentTypeRepository{
    @Override
    public RentType findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        RentType rentType = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from rent_type where rent_type_id = ?");
                statement.setInt(1, id);

                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    String rentTypeName = resultSet.getString("rent_type_name");
                    double rentTypeCost = resultSet.getDouble("rent_type_cost");
                    rentType = new RentType(id, rentTypeName, rentTypeCost);
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
        return rentType;
    }
}
