package com.p5.adoptions.services;

import com.p5.adoptions.model.UserDTO;
import com.p5.adoptions.model.adapters.UserAdapter;
import com.p5.adoptions.repository.UserRepository;
import com.p5.adoptions.repository.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer addUser (UserDTO userDTO){

        User user = UserAdapter.fromDTO(userDTO);

        userRepository.save(user);

        return userDTO.getId();
    }

}
