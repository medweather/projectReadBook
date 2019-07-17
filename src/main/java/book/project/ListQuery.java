package book.project;

import book.project.model.Book;
import book.project.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

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

    public List<Book> getBooks(int first, int pageSize, String sortField, boolean asc) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);

        criteria.setFirstResult(first);
        criteria.setMaxResults(pageSize);

        if(sortField != null) {
            if(asc) {
                criteria.addOrder(Order.asc(sortField));
            }
            else {
                criteria.addOrder(Order.desc(sortField));
            }
        }

        return criteria.list();
    }

    public Long getTotalRegistr() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Book.class);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }
}
