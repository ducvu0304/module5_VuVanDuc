package rikkei.thcustomermanageorm.service;

import rikkei.thcustomermanageorm.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerList();
    Customer findCustomerById(int customerId);
    boolean updateCustomer(int customerId);
    boolean deleteCustomerById(int customerId);
    void save(Customer customer);
}
