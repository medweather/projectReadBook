package book.project.beans;

import book.project.ListQuery;
import book.project.model.Book;
import book.project.model.User;
import org.primefaces.event.CellEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class EditBean implements Serializable {

    private List<Book> books;
    private List<User> filteredBookUser;
    private User user1;

    public List<Book> getBooks() {
        return books;
    }


    public List<User> getFioSearch(String query){
        List<User> filteredFio = new ArrayList<User>();

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            User us = book.getBookUser();
            if(us.getFio().toLowerCase().contains(query)) {
                filteredFio.add(us);
            }
        }
        return filteredFio;
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }


    public List<User> getFilteredBookUser() {
        return filteredBookUser;
    }

    public void setFilteredBookUser(List<User> filteredBookUser) {
        this.filteredBookUser = filteredBookUser;
    }

    public String showData() {
        return "index.xhtml?faces-redirect=true";
    }
}
