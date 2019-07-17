package book.project;

import book.project.model.Book;
import book.project.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.GregorianCalendar;

class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            StandardServiceRegistryBuilder serviceBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(serviceBuilder.build());

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            User user1 = new User();
            user1.setFio("Петров Иван Иванович");
            user1.setLogin("petrov");
            user1.setPass("3464564");

            User user2 = new User();
            user2.setFio("Иванов Петр Сергеевич");
            user2.setLogin("ivanov");
            user2.setPass("jkfhvdfg84");

            User user3 = new User();
            user3.setFio("Пупкин Василий Степанович");
            user3.setLogin("pupkin");
            user3.setPass("jdfvj7434");

            User user4 = new User();
            user4.setFio("Сергеев Иван Васильевич");
            user4.setLogin("sergeev");
            user4.setPass("jkhfdug7d");

            User user5 = new User();
            user5.setFio("Осечкин Леонид Валерьянович");
            user5.setLogin("osechkin");
            user5.setPass("mdnvjkdfv7");

            User user6 = new User();
            user6.setFio("Дудкин Семен Семенович");
            user6.setLogin("dudkin");
            user6.setPass("dhvjdf7433");

            User user7 = new User();
            user7.setFio("Михайлов Сергей Дмитриевич");
            user7.setLogin("mikhailov");
            user7.setPass("kkjfnvfd749");

            User user8 = new User();
            user8.setFio("Борисов Андрей Вонифатьевич");
            user8.setLogin("borisov");
            user8.setPass(",dfv-sdflsd");

            User user9 = new User();
            user9.setFio("Максимов Максим Максимович");
            user9.setLogin("maksimov");
            user9.setPass("skdf79sdfvjs");

            User user10 = new User();
            user10.setFio("Голубева Любовь Александровна");
            user10.setLogin("golubeva");
            user10.setPass("jvnjnjskdfnv");

            Book book1 = new Book();
            book1.setTitle("Война и мир");
            GregorianCalendar calendar1 = new GregorianCalendar(2017, 3, 13);
            Date date1 = calendar1.getTime();
            book1.setDate(date1);
            book1.setBookUser(user1);

            Book book2 = new Book();
            book2.setTitle("Преступление и наказание");
            GregorianCalendar calendar2 = new GregorianCalendar(2018, 6, 27);
            Date date2 = calendar2.getTime();
            book2.setDate(date2);
            book2.setBookUser(user2);

            Book book3 = new Book();
            book3.setTitle("Тихий Дон");
            GregorianCalendar calendar3 = new GregorianCalendar(2019, 3, 5);
            Date date3 = calendar3.getTime();
            book3.setDate(date3);
            book3.setBookUser(user3);

            Book book4 = new Book();
            book4.setTitle("Властелин колец");
            GregorianCalendar calendar4 = new GregorianCalendar(2017, 4, 23);
            Date date4 = calendar4.getTime();
            book4.setDate(date4);
            book4.setBookUser(user4);

            Book book5 = new Book();
            book5.setTitle("Лед и пламя");
            GregorianCalendar calendar5 = new GregorianCalendar(2014, 12, 27);
            Date date5 = calendar5.getTime();
            book5.setDate(date5);
            book5.setBookUser(user5);

            Book book6 = new Book();
            book6.setTitle("Java для чайников");
            GregorianCalendar calendar6 = new GregorianCalendar(2015, 9, 18);
            Date date6 = calendar6.getTime();
            book6.setDate(date6);
            book6.setBookUser(user6);

            Book book7 = new Book();
            book7.setTitle("Мастер и Маргарита");
            GregorianCalendar calendar7 = new GregorianCalendar(2018, 8, 28);
            Date date7 = calendar7.getTime();
            book7.setDate(date7);
            book7.setBookUser(user7);

            Book book8 = new Book();
            book8.setTitle("Дубровский");
            GregorianCalendar calendar8 = new GregorianCalendar(2013, 7, 22);
            Date date8 = calendar8.getTime();
            book8.setDate(date8);
            book8.setBookUser(user8);

            Book book9 = new Book();
            book9.setTitle("Пиши, сокращай");
            GregorianCalendar calendar9 = new GregorianCalendar(2016, 11, 20);
            Date date9 = calendar9.getTime();
            book9.setDate(date9);
            book9.setBookUser(user9);

            Book book10 = new Book();
            book10.setTitle("Spring 5 для профессионалов");
            GregorianCalendar calendar10 = new GregorianCalendar(2019, 4, 12);
            Date date10 = calendar10.getTime();
            book10.setDate(date10);
            book10.setBookUser(user10);

            session.save(user1);
            session.save(user2);
            session.save(user3);
            session.save(user4);
            session.save(user5);
            session.save(user6);
            session.save(user7);
            session.save(user8);
            session.save(user9);
            session.save(user10);

            session.save(book1);
            session.save(book2);
            session.save(book3);
            session.save(book4);
            session.save(book5);
            session.save(book6);
            session.save(book7);
            session.save(book8);
            session.save(book9);
            session.save(book10);

            transaction.commit();
            session.close();
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
