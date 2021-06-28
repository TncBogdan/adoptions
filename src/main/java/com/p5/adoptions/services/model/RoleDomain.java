package com.p5.adoptions.services.model;

import com.p5.adoptions.repository.entity.RolesEnum;

import javax.persistence.*;

public class RoleDomain {

    private Integer id;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    public RoleDomain(Integer id, RolesEnum role) {
        this.id = id;
        this.role = role;
    }

    public RoleDomain() {
    }

    public Integer getId() {
        return id;
    }

    public RoleDomain setId(Integer id) {
        this.id = id;
        return this;
    }

    public RolesEnum getRole() {
        return role;
    }

    public RoleDomain setRole(RolesEnum role) {
        this.role = role;
        return this;
    }
}
