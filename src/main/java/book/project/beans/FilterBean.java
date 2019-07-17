package book.project.beans;

import book.project.ListQuery;
import book.project.model.Book;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class FilterBean implements Serializable {

    private List<Book> books;

    private List<Book> filteredBooks;

    @PostConstruct
    public void init() {
        ListQuery listQuery = new ListQuery();
        books = listQuery.getBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getFilteredBooks() {
        return filteredBooks;
    }

    public void setFilteredBooks(List<Book> filteredBooks) {
        this.filteredBooks = filteredBooks;
    }
}
