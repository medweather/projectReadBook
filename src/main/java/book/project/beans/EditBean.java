package book.project.beans;

import book.project.ListQuery;
import book.project.model.Book;
import org.primefaces.event.CellEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class EditBean implements Serializable {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    @PostConstruct
    public void init() {
        ListQuery listQuery = new ListQuery();
        books = listQuery.getBooks();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Успешно изменено", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
