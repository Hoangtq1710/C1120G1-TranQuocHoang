package service.customer;

import model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomer();

    void save(Customer customer);

    Customer findCustomerById(String id);

    void update(String id, Customer customer);

    void remove(String id);

    List<Customer> search(String search);

    List<Customer> sortCustomer(String sortBy);
}
