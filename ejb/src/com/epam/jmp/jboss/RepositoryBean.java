package com.epam.jmp.jboss;

import javax.ejb.Stateless;

@Stateless(name = "RepositoryBeanEJB")
public class RepositoryBean {

    public RepositoryBean() {
    }

    public String sayHello() {
        return "Hello, World!";
    }

}
