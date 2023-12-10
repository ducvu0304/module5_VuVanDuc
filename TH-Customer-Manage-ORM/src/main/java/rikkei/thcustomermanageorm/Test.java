package rikkei.thcustomermanageorm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rikkei.thcustomermanageorm.model.Customer;
import rikkei.thcustomermanageorm.utils.HibernateUtil;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyyMM-dd");

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Customer customer =  session.get(Customer.class, 6);
            session.delete(customer);

            transaction.commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }


    }
}
