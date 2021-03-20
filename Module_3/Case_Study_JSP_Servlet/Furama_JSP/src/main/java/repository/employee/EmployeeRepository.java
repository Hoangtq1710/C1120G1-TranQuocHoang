package repository.employee;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAllEmployee();

    void save(Employee employee);

    Employee findEmployeeById(int id);

    void update(int id, Employee employee);

    void remove(int id);

    List<Employee> search(String search);

    List<Employee> sortEmployee(String sortBy);
}
