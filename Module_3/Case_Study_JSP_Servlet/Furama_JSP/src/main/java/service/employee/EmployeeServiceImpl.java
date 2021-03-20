package service.employee;

import model.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository repository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAllEmployee();
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return repository.findEmployeeById(id);
    }

    @Override
    public void update(int id, Employee employee) {
        repository.update(id,employee);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<Employee> search(String search) {
        return repository.search(search);
    }

    @Override
    public List<Employee> sortEmployee(String sortBy) {
        return repository.sortEmployee(sortBy);
    }
}
