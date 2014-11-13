package com.epam.jmp.jboss;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "ServiceBeanEJB")
public class ServiceBean {

    @EJB
    private RepositoryBean repositoryBean;

    public ServiceBean() {
    }

    public String sayHello() {
        return repositoryBean.sayHello();
    }


}
