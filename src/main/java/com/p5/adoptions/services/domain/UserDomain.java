package com.p5.adoptions.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
public class UserDomain {

    private Integer id;

    @Email
    private String email;

    private String password;

}
