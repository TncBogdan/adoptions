package com.p5.adoptions.controllers.dto;

import javax.validation.constraints.Email;

public record UserDTO (

    Integer id,

    @Email
    String email,

    String password) {

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }
}
