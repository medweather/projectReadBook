package book.project.beans;

import book.project.BookDAO;
import book.project.ListQuery;
import book.project.lazy.LazyBookDataModel;
import book.project.model.User;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

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

    private User user1;
    private LazyDataModel<BookDAO> lazyDataModel;
    private BookDAO selectedBook;


    public List<User> getFioSearch(String query){
        ListQuery listQuery = new ListQuery();
        List<User> users = new ArrayList<>();
        users = listQuery.getUsers();
        List<User> filteredFio = new ArrayList<User>();

        for (int i = 0; i < users.size(); i++) {
            User us = users.get(i);
            if(us.getFio().toLowerCase().contains(query)) {
                filteredFio.add(us);
            }
        }
        return filteredFio;
    }

    @PostConstruct
    public void init() {
        ListQuery listQuery = new ListQuery();
        lazyDataModel = new LazyBookDataModel(listQuery.getBooks());
    }



    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public LazyDataModel<BookDAO> getLazyDataModel() {
        return lazyDataModel;
    }

    public BookDAO getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(BookDAO selectedBook) {
        this.selectedBook = selectedBook;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((BookDAO) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((BookDAO) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((BookDAO) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
