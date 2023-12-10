package rikkei.thcustomermanageorm.dao;

import rikkei.thcustomermanageorm.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomerList();
    Customer findCustomerById(int customerId);
    void updateCustomer(Customer customer);
    void deleteCustomerById(Customer customer);
    void save(Customer customer);
}
