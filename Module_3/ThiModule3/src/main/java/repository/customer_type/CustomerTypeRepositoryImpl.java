package repository.customer_type;

import model.CustomerType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository{
    public static final String FIND_BY_CUS_TYPE_ID = "select * from customer_type where customer_type_id = ?;";

    @Override
    public CustomerType findCusTypeById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        CustomerType customerType = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_BY_CUS_TYPE_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String cusTypeName = resultSet.getString("customer_type_name");
                    int cusTypeId = resultSet.getInt("customer_type_id");
                    customerType = new CustomerType(cusTypeId, cusTypeName);
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
        return customerType;
    }
}
