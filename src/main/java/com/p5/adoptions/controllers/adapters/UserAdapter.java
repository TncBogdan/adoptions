package com.p5.adoptions.controllers.adapters;

import com.p5.adoptions.repository.entity.User;
import com.p5.adoptions.services.model.UserDomain;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    public static UserDomain toDTO(User user){
        return new UserDomain(user.getId(),user.getEmail(), user.getPassword());
    }

    public static User fromDTO(UserDomain userDomain){
        return new User()
                .setEmail(userDomain.getEmail())
                .setPassword(userDomain.getPassword());
    }

    public static List<UserDomain>toListDTO(List<User>userList){
        List<UserDomain>dtoUsers = new ArrayList<>();
        userList.forEach(user -> dtoUsers.add(toDTO(user)));
        return dtoUsers;
    }
}
