package com.p5.adoptions.services.adapters;

import com.p5.adoptions.repository.entity.Role;
import com.p5.adoptions.repository.entity.User;
import com.p5.adoptions.services.model.RoleDomain;
import com.p5.adoptions.services.model.UserDomain;

import java.util.ArrayList;
import java.util.List;

public class RoleAdapterDomain {

    public static RoleDomain toDomain(Role role){
        return new RoleDomain(role.getId(), role.getRole());
    }

    public static Role fromDomain(RoleDomain roleDomain){
        return new Role()
                .setId(roleDomain.getId())
                .setRole(roleDomain.getRole());
    }

    public static List<RoleDomain> toListDomain(List<Role>userList){
        List<RoleDomain>dtoUsers = new ArrayList<>();
        userList.forEach(user -> dtoUsers.add(toDomain(user)));
        return dtoUsers;
    }
}
