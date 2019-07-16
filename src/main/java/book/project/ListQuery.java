package book.project;

import book.project.model.Book;
import book.project.model.User;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ListQuery {

    public List<User> getUsers()
    {
        List<User> users = new ArrayList<User>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        session.close();
        return users;
    }

    public List<Book> getBooks()
    {
        List<Book> books = new ArrayList<Book>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        books = session.createCriteria(Book.class).list();
        session.close();
        return books;
    }
}
