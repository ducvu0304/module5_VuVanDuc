package rikkei.thcustomermanageorm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rikkei.thcustomermanageorm.model.Address;
import rikkei.thcustomermanageorm.model.Customer;
import rikkei.thcustomermanageorm.model.Employee;
import rikkei.thcustomermanageorm.model.Product;
import rikkei.thcustomermanageorm.utils.HibernateUtil;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
       try {
           Session session = HibernateUtil.getSessionFactory().openSession();
           Transaction transaction = session.beginTransaction();

           Address address = new Address();
           address.setStreet("Le Trong Tan");
           address.setCity("Hồ Chí Minh");

           Employee employee = new Employee();
           employee.setName("Nguyễn Văn A");
           employee.setAddress(address);

           session.save(employee);

           transaction.commit();
           session.close();
       }catch (HibernateException e) {
           e.printStackTrace();
       }


    }
}
