package com.soren.repository.impl;

import com.soren.model.Product;
import com.soren.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = em.createQuery("select p from Product p where p.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

    }

    @Override
    public void save(Product product) {
        if (product.getId() != null){
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    @Override
    public void remove(Long id) {
        Product product = findById(id);
        if (product != null){
            em.remove(product);
        }
    }
}
