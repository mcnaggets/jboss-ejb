package com.epam.jmp.jboss.model;

public class User {

    private String login;

    private String name;

    public User(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"login\":\"" + login + '\"' +
                ", \"name\":\"" + name + '"' +
                '}';
    }
}
