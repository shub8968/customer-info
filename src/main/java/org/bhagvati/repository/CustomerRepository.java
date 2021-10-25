package org.bhagvati.repository;

import org.bhagvati.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
public class CustomerRepository {

    @PersistenceContext(unitName = "PostgresPool")
    EntityManager em;

    @Transactional(REQUIRED)
    public void addCustomer(Customer customer){
        em.persist(customer);
    }

    @Transactional(REQUIRED)
    public void removeCustomer(Integer id){
        em.remove(id);
    }

    @Transactional(REQUIRED)
    public Customer findCustomer(Integer id){
         Customer customer =  em.find(Customer.class, 1);
         System.out.println(customer.getName());
        return em.find(Customer.class, 1);
    }

    @Transactional(REQUIRED)
    public Customer editCustomer(Customer customer) {
        return em.merge(customer);
    }

}
