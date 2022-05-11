package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpaCustomerDAO implements CustomerDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.flights");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveCustomer(Customer c)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCustomer(Customer c)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer c) {
        saveCustomer(c);
    }

    @Override
    public List<Customer> getCustomers() {
        TypedQuery<Customer> query = entityManager.createQuery(
                "SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    public String getCustomerPass(String userID)
    {
        String myquery  = "SELECT PASSWORD FROM CUSTOMER WHERE NAME = '" + userID + "'";
        String pass = entityManager.createNativeQuery(myquery).getSingleResult().toString();

        return pass;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
