package com.soren.repository;

import com.soren.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    static List<Customer> listCustomer = new ArrayList<>();

    static {
        listCustomer.add(new Customer(0, "Tran Thi Le Quang","quang@codegym.vn","Da Nang"));
        listCustomer.add(new Customer(1, "Nguyen Thi Thuan","thuan@codegym.vn","Hue"));
        listCustomer.add(new Customer(2, "Nguyen Hoang Bao Ngoc","ngoc@codegym.vn","Hue"));
        listCustomer.add(new Customer(3, "Nguyen Binh Son","son@codegym.vn","Quang Nam"));
        listCustomer.add(new Customer(4, "Tran Quoc Hoang","hoang@codegym.vn","Quang Nam"));
    }

    @Override
    public List<Customer> findAll() {
        return listCustomer;
    }
}
