package repository.service_type;

import model.ServiceType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository{
    @Override
    public ServiceType findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ServiceType serviceType = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from service_type where service_type_id = ?");
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    String serviceTypeName = resultSet.getString("service_type_name");
                    serviceType = new ServiceType(id, serviceTypeName);

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
        return serviceType;
    }
}
