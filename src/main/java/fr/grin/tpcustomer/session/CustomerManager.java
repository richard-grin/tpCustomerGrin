package fr.grin.tpcustomer.session;

import fr.grin.tpcustomer.entities.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.persistence.PersistenceContext;

/**
 * Gère la persistance des Customers.
 * @author grin
 */
@Stateless
public class CustomerManager {
    @PersistenceContext
    private EntityManager em;

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    public Customer update(Customer customer) {
        return em.merge(customer);
    }
    
    public void persist(Customer customer) {
        em.persist(customer);
    }

}
