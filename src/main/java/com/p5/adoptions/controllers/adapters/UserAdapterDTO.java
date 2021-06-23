package com.p5.adoptions.controllers.adapters;

import com.p5.adoptions.controllers.dto.UserDTO;
import com.p5.adoptions.services.model.UserDomain;

import java.util.ArrayList;
import java.util.List;

public class UserAdapterDTO {

    public static UserDTO toDTO(UserDomain userDomain) {
        return new UserDTO(userDomain.getId(), userDomain.getEmail(), userDomain.getPassword());
    }

    public static UserDomain fromDTO(UserDTO userDTO) {
        return new UserDomain()
                .setEmail(userDTO.getEmail())
                .setPassword(userDTO.getPassword());
    }

    public static List<UserDTO> toListDTO(List<UserDomain> userList) {
        List<UserDTO> dtoUsers = new ArrayList<>();
        userList.forEach(user -> dtoUsers.add(toDTO(user)));
        return dtoUsers;
    }
}
