package com.soren.repository.impl;

import com.soren.model.Customer;
import com.soren.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static Map<Integer, Customer> map = new HashMap<>();

    static {
        map.put(1, new Customer(1,"Hoang", "hoang@gmail.com", "Quang Nam"));
        map.put(2, new Customer(2,"Thuan", "thuan@gmail.com", "Hue"));
        map.put(3, new Customer(3,"Vi", "vi@gmail.com", "Da Nang"));
        map.put(4, new Customer(4,"Quang", "quang@gmail.com", "Da Nang"));
        map.put(5, new Customer(5,"Khoa", "khoa@gmail.com", "Hue"));
        map.put(6, new Customer(6,"Ngoc", "ngoc@gmail.com", "Quang Tri"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Customer customer) {
        map.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return map.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        map.put(id, customer);
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public boolean isExistId(int id) {
        return map.containsKey(id);
    }
}
