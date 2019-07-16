package book.project;

import book.project.model.Book;
import book.project.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ListQuery {

    public List<User> getUsers()
    {
        insertTable();
        List<User> users = new ArrayList<User>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        session.close();
        return users;
    }

    private void insertTable(){
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

        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(book1);
        session.save(book2);
        session.save(book3);
        transaction.commit();

        session.close();
    }
}
