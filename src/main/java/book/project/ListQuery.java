package book.project;

import book.project.model.Book;
import book.project.model.User;
import org.hibernate.Session;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ListQuery {

    @SuppressWarnings("unchecked")
    public List<User> getUsers()
    {
        List<User> users = new ArrayList<User>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    @SuppressWarnings("unchecked")
    public List<Book> getBooks()
    {
        List<Book> books = new ArrayList<Book>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        books = session.createCriteria(Book.class).list();
        return books;
    }
}
