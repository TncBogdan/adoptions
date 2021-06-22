package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.services.model.UserDomain;
import com.p5.adoptions.services.adapters.UserAdapter;
import com.p5.adoptions.repository.repositoryInterfaces.UserRepository;
import com.p5.adoptions.repository.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer addUser (UserDomain userDomain){

        User user = UserAdapter.fromDTO(userDomain);

        userRepository.save(user);

        return userDomain.getId();
    }

}
