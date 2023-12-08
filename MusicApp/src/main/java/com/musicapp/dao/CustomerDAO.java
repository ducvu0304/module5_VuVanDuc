package com.musicapp.dao;

import com.musicapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    Customer create();
    List<Customer> findAlCustomers();
    Optional<Customer> findCustomerById(int customerId);
    void deleteCustomerById(int id);
    void update (Customer customer);
    void save(Customer customer);

}
