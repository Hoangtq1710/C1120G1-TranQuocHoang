package service.customer;

import model.Customer;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    CustomerRepository repository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAllCustomer() {
        return repository.findAllCustomer();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Customer findCustomerById(String id) {
        return repository.findCustomerById(id);
    }

    @Override
    public void update(String id, Customer customer) {
        repository.update(id, customer);
    }

    @Override
    public void remove(String id) {
        repository.remove(id);
    }

    @Override
    public List<Customer> search(String search) {
        return repository.search(search);
    }

    @Override
    public List<Customer> sortCustomer(String sortBy) {
        return repository.sortCustomer(sortBy);
    }
}
