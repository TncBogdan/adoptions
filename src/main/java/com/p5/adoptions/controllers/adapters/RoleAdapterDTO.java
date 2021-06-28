package com.p5.adoptions.controllers.adapters;

import com.p5.adoptions.controllers.dto.RoleDTO;
import com.p5.adoptions.controllers.dto.UserDTO;
import com.p5.adoptions.services.model.RoleDomain;
import com.p5.adoptions.services.model.UserDomain;

import java.util.ArrayList;
import java.util.List;

public class RoleAdapterDTO {

    public static RoleDTO toDTO(RoleDomain roleDomain) {
        return new RoleDTO(roleDomain.getId(), roleDomain.getRole());
    }

    public static RoleDomain fromDTO(RoleDTO roleDTO) {
        return new RoleDomain().setId(roleDTO.getId()).setRole(roleDTO.getRole());
    }

    public static List<RoleDTO> toListDTO(List<RoleDomain> userList) {
        List<RoleDTO> dtoUsers = new ArrayList<>();
        userList.forEach(user -> dtoUsers.add(toDTO(user)));
        return dtoUsers;
    }
}
