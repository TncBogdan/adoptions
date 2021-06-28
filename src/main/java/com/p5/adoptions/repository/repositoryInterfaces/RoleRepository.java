package com.p5.adoptions.repository.repositoryInterfaces;

import com.p5.adoptions.services.model.RolesEnumDomain;
import com.p5.adoptions.repository.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

        Optional<Role> findByRole(RolesEnumDomain rolesEnum);
}
