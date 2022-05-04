package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class JpaCustomerDAO implements CustomerDAO{

    Customer LoggedInCustomer = null;

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

<<<<<<< HEAD
    public String getCustomerPass(String userID)
    {
        String myquery  = "SELECT PASSWORD FROM CUSTOMER WHERE NAME = '" + userID + "'";
        String pass = entityManager.createNativeQuery(myquery).getSingleResult().toString();

        return pass;
    }


    // Jelenleg bejelentkezett customer beállítása
    public void SetLoggedInCustomer(String userID){
        try( CustomerDAO cDao = new JpaCustomerDAO()){
            List<Customer> templi = cDao.getCustomers();
            for(Customer c : templi){
                if(Objects.equals(c.getName(), userID))
                {
                    LoggedInCustomer = c;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


=======
>>>>>>> searchpage

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
