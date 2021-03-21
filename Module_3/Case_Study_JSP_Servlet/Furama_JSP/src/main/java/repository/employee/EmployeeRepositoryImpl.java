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
    public static final String SELECT_EMP_BY_ID = "select * from employee where employee_id = ?;";
    public static final String SELECT_ALL_EMP = "select * from employee;";
    public static final String INSERT_NEW_EMP = "insert into employee(employee_name,position_id,education_degree_id," +
                                                            "division_id,employee_birthday,employee_id_card,employee_salary," +
                                                            "employee_phone,employee_email,employee_address,username) " +
                                                "values (?,?,?,?,?,?,?,?,?,?,?);";
    public static final String UPDATE_EMP = "update employee " +
                                            "set employee_name = ?, position_id = ?, education_degree_id = ?, " +
                                                "division_id = ?, employee_birthday = ?, employee_id_card = ?, " +
                                                "employee_salary = ?, employee_phone = ?, employee_email = ?, " +
                                                "employee_address = ?" +
                                            "where employee_id = ?;";
    public static final String SEARCH_EMP = "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee inner join `position` on `position`.position_id = employee.position_id \n" +
                                            "where `position`.position_name like ?\n" +
                                            "union \n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee inner join education_degree on education_degree.education_degree_id = employee.education_degree_id \n" +
                                            "where education_degree.education_degree_name like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee inner join division on division.division_id = employee.division_id \n" +
                                            "where division.division_name like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_name like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_birthday like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_id_card like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_salary like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_phone like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_email like ?\n" +
                                            "union\n" +
                                            "select employee_id,employee.position_id,employee.education_degree_id,employee.division_id,username,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address from employee\n" +
                                            "where employee_address like ?";


    PositionService positionService = new PositionServiceImpl();
    EduDegreeService eduDegreeService = new EduDegreeServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public List<Employee> findAllEmployee() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> listEmployee = new ArrayList<>();
        Employee employee;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMP);

                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    employee = common(resultSet);

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

    private Employee common(ResultSet resultSet) throws SQLException {
        Position position;
        EduDegree eduDegree;
        Division division;
        User user;

        int employeeId = resultSet.getInt("employee_id");
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

//      user = new User(username,username); // mặc định password = username

        return new Employee(employeeId,name,birthday,idCard,salary,phone,email,address,position,eduDegree,division,user);
    }

    @Override
    public Employee findEmployeeById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMP_BY_ID);
                statement.setInt(1, id);

                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    employee = common(resultSet);
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

        return employee;
    }

    @Override
    public void update(int id, Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_EMP);
                statement.setString(1,employee.getEmployeeName());
                statement.setInt(2,employee.getPosition().getPositionId());
                statement.setInt(3,employee.getEduDegree().getEduDegreeId());
                statement.setInt(4,employee.getDivision().getDivisionId());
                statement.setString(5, employee.getEmployeeBirthday().toString());
                statement.setString(6, employee.getEmployeeIdCard());
                statement.setInt(7, (int) employee.getEmployeeSalary());
                statement.setString(8,employee.getEmployeePhone());
                statement.setString(9, employee.getEmployeeEmail());
                statement.setString(10, employee.getEmployeeAddress());

                statement.setInt(11,id);

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
    public void remove(int id) {

    }

    @Override
    public List<Employee> search(String search) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        List<Employee> listEmployee = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_EMP);
                statement.setString(1,'%'+search+'%');
                statement.setString(2,'%'+search+'%');
                statement.setString(3,'%'+search+'%');
                statement.setString(4,'%'+search+'%');
                statement.setString(5,'%'+search+'%');
                statement.setString(6,'%'+search+'%');
                statement.setString(7,'%'+search+'%');
                statement.setString(8,'%'+search+'%');
                statement.setString(9,'%'+search+'%');
                statement.setString(10,'%'+search+'%');

                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    employee = common(resultSet);

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
    public List<Employee> sortEmployee(String sortBy) {
        return null;
    }
}
