package rikkei.thcustomermanageorm.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import rikkei.thcustomermanageorm.model.Customer;
import rikkei.thcustomermanageorm.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository")
public class CustomerDaoImpl implements CustomerDao{
    private static Session session = null;
    private static Transaction transaction = null;

    @Override
    public List<Customer> getCustomerList() {
        int firstResult = 0;
        int maxResult = 4;
        List<Customer> customerList = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String hql = "FROM Customer";
            Query<Customer> query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            customerList = query.getResultList();

        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return customerList;
    }

    @Override
    public Customer findCustomerById(int customerId) {
        Customer customer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            customer = session.get(Customer.class, customerId);
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }

    }

    @Override
    public void deleteCustomerById(Customer customer) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public void save(Customer customer) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
