package book.project;

import book.project.model.Book;
import book.project.model.User;
import org.hibernate.Session;

import javax.enterprise.context.RequestScoped;
import java.text.SimpleDateFormat;
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
    public List<BookDAO> getBooks()
    {
        List<Book> booksEntity = new ArrayList<Book>();
        List<BookDAO> booksDAO = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        booksEntity = session.createCriteria(Book.class).list();
        for (Book bookEntity : booksEntity) {
            BookDAO bookDAO = new BookDAO();
            bookDAO.setId(String.valueOf(bookEntity.getId()));
            bookDAO.setTitle(bookEntity.getTitle());

            String dateString;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateString = simpleDateFormat.format(bookEntity.getDate());

            bookDAO.setDate(dateString);
            bookDAO.setBookUser(bookEntity.getBookUser().getFio());
            booksDAO.add(bookDAO);
        }
        return booksDAO;
    }
}
