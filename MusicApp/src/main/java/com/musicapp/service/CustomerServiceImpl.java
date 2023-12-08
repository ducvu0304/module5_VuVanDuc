package com.musicapp.service;

import com.musicapp.dao.CustomerDAO;
import com.musicapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer create() {
        return null;
    }

    @Override
    public List<Customer> findAlCustomers() {
        return customerDAO.findAlCustomers();
    }

    @Override
    public Optional<Customer> findCustomerById(int customerId) {
        return Optional.empty();
    }

    @Override
    public void deleteCustomerById(int customerId) {
        customerDAO.deleteCustomerById(customerId);
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }
}
