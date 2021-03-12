package practice_customer_management.service;

import practice_customer_management.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private static Map<Integer, Customer> customerList ;

    static  {
        customerList.put(1,new Customer(1,"Quang","quang@gmail.com","Da Nang"));
        customerList.put(2,new Customer(2,"Dong","dong@gmail.com","Hue"));
        customerList.put(3,new Customer(3,"Ngoc","ngoc@gmail.com","Quang Tri"));
        customerList.put(4,new Customer(4,"Hoang","hoang@gmail.com","Quang Nam"));
        customerList.put(5,new Customer(5,"Thuan","thuan@gmail.com","Hue"));
        customerList.put(6,new Customer(6,"Vi","vi@gmail.com","Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
