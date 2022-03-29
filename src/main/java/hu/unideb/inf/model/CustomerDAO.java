package hu.unideb.inf.model;

import java.util.List;

public interface CustomerDAO extends AutoCloseable{

    void saveCustomer(Customer a);

    void deleteCustomer(Customer a);

    void updateCustomer(Customer a);

    List<Customer> getCustomers();

}
