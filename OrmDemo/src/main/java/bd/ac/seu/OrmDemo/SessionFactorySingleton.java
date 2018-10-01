package bd.ac.seu.OrmDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingleton {
    private final static SessionFactorySingleton instance = new SessionFactorySingleton();
    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {
        sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
