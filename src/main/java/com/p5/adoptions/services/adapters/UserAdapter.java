package com.p5.adoptions.services.adapters;

import com.p5.adoptions.services.domain.UserDomain;
import com.p5.adoptions.repository.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {

    public static UserDomain toDomain(User user){
        return new UserDomain(user.getId(),user.getEmail(), user.getPassword());
    }

    public static User fromDomain(UserDomain userDomain){
        return new User()
                .setEmail(userDomain.getEmail())
                .setPassword(userDomain.getPassword());
    }

    public static List<UserDomain> toListDomain(List<User>userList){
        List<UserDomain>dtoUsers = new ArrayList<>();
        userList.forEach(user -> dtoUsers.add(toDomain(user)));
        return dtoUsers;
    }
}
