package com.p5.adoptions.controllers.dto;

import com.p5.adoptions.repository.entity.RolesEnum;
import com.p5.adoptions.services.model.RolesEnumDomain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class RoleDTO {

    private Integer id;

    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    public RoleDTO() {
    }

    public RoleDTO(Integer id, RolesEnum role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public RoleDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public RolesEnum getRole() {
        return role;
    }

    public RoleDTO setRole(RolesEnum role) {
        this.role = role;
        return this;
    }
}
