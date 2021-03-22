package repository.contract;

import model.Contract;
import model.Customer;
import model.Employee;
import model.Service;
import repository.DBConnection;
import service.customer.CustomerService;
import service.customer.CustomerServiceImpl;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.service.ServiceService;
import service.service.ServiceServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository{

    public static final String INSERT_NEW_CONTRACT = "insert into contract(employee_id,customer_id,service_id,contract_start_date," +
                                                            "contract_end_date,contract_deposit,contract_total_money)\n" +
                                                            "values (?,?,?,?,?,?,?);";
    EmployeeService employeeService = new EmployeeServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();

    public static final String SELECT_ALL_CON = "select * from contract;";

    @Override
    public List<Contract> findAllContract() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Contract> listContract = new ArrayList<>();
        Contract contract = null;
        Employee employee = null;
        Customer customer = null;
        Service service = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CON);
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    int id = resultSet.getInt("contract_id");
                    Date startDate = resultSet.getDate("contract_start_date");
                    Date endDate = resultSet.getDate("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    employee = this.employeeService.findEmployeeById(resultSet.getInt("employee_id"));
                    customer = this.customerService.findCustomerById(resultSet.getString("customer_id"));
                    service = this.serviceService.findServiceById(resultSet.getString("service_id"));

                    contract = new Contract(id,startDate,endDate,deposit,totalMoney,employee,customer,service);

                    listContract.add(contract);

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
        return listContract;
    }

    @Override
    public void save(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_CONTRACT);
                statement.setInt(1,contract.getEmployee().getEmployeeId());
                statement.setString(2,contract.getCustomer().getCustomerId());
                statement.setString(3, contract.getService().getServiceId());
                statement.setString(4, contract.getContractStartDate().toString());
                statement.setString(5, contract.getContractEndDate().toString());
                statement.setInt(6, (int)contract.getContractDeposit());
                statement.setInt(7, (int)contract.getContractTotalMoney());

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
    public Contract findContractById(String id) {
        return null;
    }

    @Override
    public void update(String id, Contract contract) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Contract> search(String search) {
        return null;
    }

    @Override
    public List<Contract> sortContract(String sortBy) {
        return null;
    }
}
