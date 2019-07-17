package book.project.beans;

import book.project.ListQuery;
import book.project.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean (name = "searchUser")
@SessionScoped
public class SearchUserBean {

    private List<User> listUser = new ArrayList<User>();
    private User user1;

    public List<User> getFioSearch(String query){
        ListQuery listQuery = new ListQuery();
        listUser = listQuery.getUsers();
        List<User> filteredFio = new ArrayList<User>();

        for (int i = 0; i < listUser.size(); i++) {
            User us = listUser.get(i);
            if(us.getFio().toLowerCase().contains(query)) {
                filteredFio.add(us);
            }
        }
        return filteredFio;
    }

    public List<User> getListUser() {
        ListQuery listQuery = new ListQuery();
        listUser = listQuery.getUsers();
        return listUser;
    }

    public void setListUser(List<User> list) {
        this.listUser = list;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }
}
