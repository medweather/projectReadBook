package book.project;

import book.project.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean (name = "main")
@SessionScoped
public class MainController {

    private User user = new User();
    ListQuery query = new ListQuery();
    private List<User> list = new ArrayList<User>();


    public List<User> getList() {
        list = query.listUser();
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
