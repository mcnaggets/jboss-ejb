package com.epam.jmp.jboss.ejb;

import com.epam.jmp.jboss.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.List;

@Stateless(name = "ServiceBeanEJB")
public class ServiceBean {

    @EJB
    private RepositoryBean repositoryBean;

    public ServiceBean() {
    }

    public String sayHello() {
        return repositoryBean.sayHello();
    }

    public List<User> getUsers() {
        return repositoryBean.getUsers();
    }

    public User getUser(String userId) {
        return repositoryBean.getUser(userId);
    }


}
