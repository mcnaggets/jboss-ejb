package com.epam.jmp.jboss.ejb;

import com.epam.jmp.jboss.model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "RepositoryBeanEJB")
public class RepositoryBean {

    @PersistenceContext
    private EntityManager entityManager;

    public RepositoryBean() {
    }

    public String sayHello() {
        return "Hello, World!";
    }

    public List<User> getUsers() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    public User getUser(String userId) {
        return entityManager.find(User.class, userId);
    }

    @PostConstruct
    void init() {
        entityManager.persist(new User("admin", "Jack Patton"));
        entityManager.persist(new User("test", "John Snow"));
        entityManager.persist(new User("guest", "Unknown"));
    }

}
