package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaCustomerDAO implements CustomerDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveCustomer(Customer a)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(Customer a)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer a) {
        saveCustomer(a);
    }

    @Override
    public List<Customer> getCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery(
                "SELECT a FROM Customer a", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void close() throws Exception {

    }
}
