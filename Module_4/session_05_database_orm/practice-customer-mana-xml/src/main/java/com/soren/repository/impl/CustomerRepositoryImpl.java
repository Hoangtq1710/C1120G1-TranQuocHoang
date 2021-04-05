package com.soren.repository.impl;

import com.soren.entity.Customer;
import com.soren.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = BaseRepository.entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        if (customer.getId() != null){
            BaseRepository.entityManager.persist(customer);
        } else {
            BaseRepository.entityManager.merge(customer);
        }
        transaction.commit();
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(customer);
        transaction.commit();
    }
}
