package com.p5.adoptions.controllers.mapper;

import com.p5.adoptions.controllers.dto.UserDTO;
import com.p5.adoptions.services.domain.UserDomain;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDomain toUser(UserDTO userDTO);

    UserDTO toDTo(UserDomain userDomain);

    List<UserDTO> toListDTO(List<UserDomain> userDomainList);
}
