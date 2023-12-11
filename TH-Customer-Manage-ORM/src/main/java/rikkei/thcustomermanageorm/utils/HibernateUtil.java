package rikkei.thcustomermanageorm.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rikkei.thcustomermanageorm.model.Customer;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static  {
        try {
           sessionFactory = new Configuration()
                   .configure("hibernate.conf.xml")
                   .buildSessionFactory();

        }catch (Throwable e) {
            System.out.println("SessionFactory creation failed.");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
