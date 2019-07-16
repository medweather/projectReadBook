package book.project.model;

import java.util.Date;

public class Book {

    private int Id;
    private String Title;
    private Date Date;
    private User BookUser;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public User getBookUser() {
        return BookUser;
    }

    public void setBookUser(User bookUser) {
        BookUser = bookUser;
    }
}
