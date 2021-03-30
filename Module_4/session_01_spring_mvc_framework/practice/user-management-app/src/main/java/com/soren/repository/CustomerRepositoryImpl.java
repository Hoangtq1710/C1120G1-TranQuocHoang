package com.soren.repository;

import com.soren.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    static List<Customer> listCustomer = new ArrayList<>();

    static {
        listCustomer.add(new Customer(0,"Hoang Le Quang", "quang@codegym.vn", "Da Nang"));
        listCustomer.add(new Customer(1,"Nguyen Ngoc Thuan", "thuan@codegym.vn", "Hue"));
        listCustomer.add(new Customer(2,"Nguyen Hoang Bao Ngoc", "ngoc@codegym.vn", "Hue"));
        listCustomer.add(new Customer(3,"Tran Hoang Sang", "sang@codegym.vn", "Da Nang"));
        listCustomer.add(new Customer(4,"Tran Quoc Hoang", "hoang@codegym.vn", "Quang Nam"));
    }
    @Override
    public List<Customer> findAll() {
        return listCustomer;
    }

    @Override
    public Customer findById(int id) {
        for(Customer customer : listCustomer){
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        Customer oldCustomer = findById(id);
        if (oldCustomer != null) {
            oldCustomer.setName(customer.getName());
            oldCustomer.setEmail(customer.getEmail());
            oldCustomer.setAddress(customer.getAddress());
        }
    }
}
