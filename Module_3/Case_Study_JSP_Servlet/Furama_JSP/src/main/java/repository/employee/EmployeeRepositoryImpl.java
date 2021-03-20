package repository.employee;

import model.*;
import repository.DBConnection;
import service.division.DivisionService;
import service.division.DivisionServiceImpl;
import service.edu_degree.EduDegreeService;
import service.edu_degree.EduDegreeServiceImpl;
import service.position.PositionService;
import service.position.PositionServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    public static final String INSERT_NEW_EMP = "insert into employee(employee_name,position_id,education_degree_id," +
                                                            "division_id,employee_birthday,employee_id_card,employee_salary," +
                                                            "employee_phone,employee_email,employee_address,username) " +
                                                "values (?,?,?,?,?,?,?,?,?,?,?);";
    PositionService positionService = new PositionServiceImpl();
    EduDegreeService eduDegreeService = new EduDegreeServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    UserService userService = new UserServiceImpl();

    public static final String SELECT_ALL_EMP = "select * from employee;";

    @Override
    public List<Employee> findAllEmployee() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> listEmployee = new ArrayList<>();
        Employee employee;
        Position position;
        EduDegree eduDegree;
        Division division;
        User user;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMP);

                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    position = this.positionService.findById(resultSet.getInt("position_id"));
                    eduDegree = this.eduDegreeService.findById(resultSet.getInt("education_degree_id"));
                    division = this.divisionService.findById(resultSet.getInt("division_id"));
                    String username = resultSet.getString("username");
                    user = this.userService.findByUserName(username);
//                    user = new User(username,username); // mặc định password = username

                    employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,position,eduDegree,division,user);

                    listEmployee.add(employee);
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
        return listEmployee;
    }

    @Override
    public void save(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_NEW_EMP);
                statement.setString(1,employee.getEmployeeName());
                statement.setInt(2,employee.getPosition().getPositionId());
                statement.setInt(3,employee.getEduDegree().getEduDegreeId());
                statement.setInt(4,employee.getDivision().getDivisionId());
                statement.setString(5,employee.getEmployeeBirthday().toString());
                statement.setString(6,employee.getEmployeeIdCard());
                statement.setInt(7, (int) employee.getEmployeeSalary());
                statement.setString(8,employee.getEmployeePhone());
                statement.setString(9,employee.getEmployeeEmail());
                statement.setString(10, employee.getEmployeeAddress());
                statement.setString(11,employee.getUser().getUsername());

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
    public Employee findEmployeeById(int id) {
        return null;
    }

    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Employee> search(String search) {
        return null;
    }

    @Override
    public List<Employee> sortEmployee(String sortBy) {
        return null;
    }
}
