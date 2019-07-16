package book.project;

import book.project.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean (name = "main")
@SessionScoped
public class MainBean {

    private List<User> listUser = new ArrayList<User>();

    public List<User> getListUser() {
        ListQuery listQuery = new ListQuery();
        listUser = listQuery.getUsers();
        return listUser;
    }

    public void setListUser(List<User> list) {
        this.listUser = list;
    }
}
