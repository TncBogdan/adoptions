package com.p5.adoptions.services.model;

import javax.validation.constraints.Email;

public class UserDomain {

    private Integer id;

    @Email
    private String email;

    private String password;

    public UserDomain() {
    }

    public UserDomain(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public UserDomain(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public UserDomain setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDomain setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDomain setPassword(String password) {
        this.password = password;
        return this;
    }
}
