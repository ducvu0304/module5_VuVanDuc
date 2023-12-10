package rikkei.thcustomermanageorm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.thcustomermanageorm.dao.CustomerDao;
import rikkei.thcustomermanageorm.model.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    @Override
    public Customer findCustomerById(int customerId) {
        return customerDao.findCustomerById(customerId);
    }

    @Override
    public boolean updateCustomer(int customerId) {
        Customer customer =  findCustomerById(customerId);
        if(customer != null) {
            customerDao.updateCustomer(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomerById(int customerId) {
        Customer customer =  findCustomerById(customerId);

        if(customer != null) {
            customerDao.deleteCustomerById(customer);
            return true;
        }
        return false;
    }


    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }
}
