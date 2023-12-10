package com.musicapp;

import com.musicapp.model.Customer;
import com.musicapp.model.Gender;
import com.musicapp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.conf.xml");
        SessionFactory sessionFactory =  configuration.buildSessionFactory();

        Session session =  sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.load(Customer.class, 1);

        System.out.println(customer);
//        session.delete(customer);

        transaction.commit();

        session.close();
    }
}
