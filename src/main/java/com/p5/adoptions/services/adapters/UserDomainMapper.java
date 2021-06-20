package com.p5.adoptions.services.adapters;

import com.p5.adoptions.repository.entity.User;
import com.p5.adoptions.services.domain.UserDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {

    UserDomain toDomain(User user);

    User fromDomain(UserDomain userDomain);

    List<UserDomain> toListDomain(List<User> userList);
}
