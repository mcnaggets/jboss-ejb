package com.epam.jmp.jboss.ejb;

import com.epam.jmp.jboss.model.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "RepositoryBeanEJB")
public class RepositoryBean {

    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User("admin", "Jack Patton"));
        USERS.add(new User("test", "John Snow"));
        USERS.add(new User("guest", "Unknown"));
    }

    public RepositoryBean() {
    }

    public String sayHello() {
        return "Hello, World!";
    }

    public List<User> getUsers() {
        return USERS;
    }

    public User getUser(String userId) {
        for (User user : USERS) {
            if (userId.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }

}
