package com.musicapp.dao;

import com.musicapp.model.Customer;
import com.musicapp.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public Customer create() {

        return null;
    }

    @Override
    public List<Customer> findAlCustomers() {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Customer> customerList =  session.createQuery("from Customer ").list();

        session.getTransaction().commit();
        session.close();
        return customerList;
    }

    @Override
    public Optional<Customer> findCustomerById(int customerId) {


        return Optional.empty();
    }

    @Override
    public void deleteCustomerById(int customerId) {

        Session session =  HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("DELETE FROM Customer where id=:id");
        query.setParameter("id", customerId);
        query.executeUpdate();

        session.close();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void save(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction  transaction =  null;
        try {
            transaction= session.beginTransaction();
            session.save(customer);
        }catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }finally {
            if(session != null) {
                session.close();
            }
        }
    }
}
