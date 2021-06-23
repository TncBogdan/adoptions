package com.p5.adoptions.controllers.dto;

import javax.validation.constraints.Email;

public record UserDTO (

    Integer getId,

    @Email
    String getEmail,

    String getPassword) {

/////!!!! must change the get properties name
//    ex: for email -> getEmail

    public Integer getId() {
        return getId;
    }

    public String getEmail() {
        return getEmail;
    }

    public String getPassword() {
        return getPassword;
    }
}
