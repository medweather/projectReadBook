package book.project;

import book.project.model.Book;
import org.primefaces.model.LazyDataModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "bookLazyView")
@ViewScoped
public class LazyView implements Serializable {

    private LazyDataModel<Book> lazyDataModel;
    private ListQuery listQuery = new ListQuery();
    private Book book;

    @PostConstruct
    public void initLazy()
    {
        lazyDataModel = new LazyBookDataModel(listQuery.getBooks());
    }

    public LazyDataModel<Book> getLazyModel() {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<Book> lazyDataModel) {
        this.lazyDataModel = lazyDataModel;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
