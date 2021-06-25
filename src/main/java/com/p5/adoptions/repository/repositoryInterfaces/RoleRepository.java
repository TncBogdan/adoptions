package com.p5.adoptions.repository.repositoryInterfaces;

import com.p5.adoptions.repository.entity.RolesEnum;
import com.p5.adoptions.repository.roles.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

        Optional<Role> findByRole(RolesEnum rolesEnum);
}
