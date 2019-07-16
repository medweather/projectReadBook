package book.project;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            StandardServiceRegistryBuilder serviceBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(serviceBuilder.build());
        }
        catch (Throwable ex)
        {
            throw new ExceptionInInitializerError();
        }
    }

    static SessionFactory getSessionFactory() throws HibernateException
    {
        return sessionFactory;
    }
}
