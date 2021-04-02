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
        TypedQuery<Customer> typedQuery = BaseRepository.entityManager.createQuery("select c from customer c",Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
        entityTransaction.commit();
    }

    @Override
    public Customer findById(int id) {
        return BaseRepository.entityManager.find(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(customer);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        Customer customer = findById(id);
        if (customer != null){
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();
            BaseRepository.entityManager.remove(customer);
            entityTransaction.commit();
        }
    }
}
