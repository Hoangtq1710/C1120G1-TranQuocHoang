package repository.service;

import model.RentType;
import model.Service;
import model.ServiceType;
import repository.DBConnection;
import service.rent_type.RentTypeService;
import service.rent_type.RentTypeServiceImpl;
import service.service_type.ServiceTypeService;
import service.service_type.ServiceTypeServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository{

    public static final String INSERT_NEW_SERVICE = "insert into service(service_id,service_name,service_area,service_max_people," +
                                                                "service_cost,rent_type_id,service_type_id,standard_room," +
                                                                "description_other_convenience,pool_area,number_of_floors)" +
                                                                "values (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SELECT_SER_BY_ID = "select * from service where service_id = ?;";


    RentTypeService rentTypeService = new RentTypeServiceImpl();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();

    @Override
    public List<Service> findAllService() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Service> listService = new ArrayList<>();
        Service service;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select  * from service;");
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    service = common(resultSet);

                    listService.add(service);
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
        return listService;
    }

    private Service common(ResultSet resultSet) throws SQLException {
        String serviceId = resultSet.getString("service_id");
        String serviceName = resultSet.getString("service_name");
        int serviceArea = resultSet.getInt("service_area");
        double serviceCost = Double.parseDouble(resultSet.getString("service_cost"));
        int serviceMaxPp = resultSet.getInt("service_max_people");
        String serviceStandRoom = resultSet.getString("standard_room");
        String serviceDesc = resultSet.getString("description_other_convenience");
        double servicePoolArea = Double.parseDouble(resultSet.getString("pool_area"));
        int serviceNof = resultSet.getInt("number_of_floors");
        RentType rentType = this.rentTypeService.findById(resultSet.getInt("rent_type_id"));
        ServiceType serviceType = this.serviceTypeService.findById(resultSet.getInt("service_type_id"));

        Service service = new Service(serviceId,serviceName,serviceArea,serviceCost,serviceMaxPp,serviceStandRoom,serviceDesc,servicePoolArea,serviceNof,rentType, serviceType);

        return service;
    }

    @Override
    public void save(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_SERVICE);
                statement.setString(1,service.getServiceId());
                statement.setString(2,service.getServiceName());
                statement.setInt(3, service.getServiceArea());
                statement.setInt(4, service.getServiceMaxPeople());
                statement.setInt(5, (int) service.getServiceCost());
                statement.setInt(6,service.getRentType().getRentTypeId());
                statement.setInt(7, service.getServiceType().getServiceTypeId());
                statement.setString(8, service.getStandardRoom());
                statement.setString(9,service.getDescription());
                statement.setInt(10,(int)service.getPoolArea());
                statement.setInt(11,service.getNumberOfFloor());

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
    public Service findServiceById(String id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Service service = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_SER_BY_ID);
                statement.setString(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    service = common(resultSet);
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
        return service;
    }

    @Override
    public void update(String id, Service service) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Service> search(String search) {
        return null;
    }

    @Override
    public List<Service> sortService(String sortBy) {
        return null;
    }
}
