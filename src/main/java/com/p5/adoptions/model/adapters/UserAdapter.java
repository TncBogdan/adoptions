package com.p5.adoptions.model.adapters;

import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.repository.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getId(),user.getEmail(), user.getPassword());
    }

    public static User fromDTO(UserDTO userDTO){
        return new User()
                .setEmail(userDTO.getEmail())
                .setPassword(userDTO.getPassword());
    }

    public static List<UserDTO>toListDTO(List<User>userList){
        List<UserDTO>dtoUsers = new ArrayList<>();
        userList.forEach(user -> dtoUsers.add(toDTO(user)));
        return dtoUsers;
    }
}
