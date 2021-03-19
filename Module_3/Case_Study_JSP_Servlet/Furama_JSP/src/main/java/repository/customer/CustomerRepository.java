package repository.customer;

import model.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAllCustomer();

    void save(Customer customer);

    Customer findCustomerById(String id);

    void update(String id, Customer customer);

    void remove(String id);

    Customer search(String name);

    List<Customer> sortCustomer(String sortBy);
}
