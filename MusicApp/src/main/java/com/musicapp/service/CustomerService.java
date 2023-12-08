package com.musicapp.service;

import com.musicapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer create();
    List<Customer> findAlCustomers();
    Optional<Customer> findCustomerById(int customerId);
    void deleteCustomerById(int id);
    void update (Customer customer);
    void save(Customer customer);
}
