package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.repository.entity.User;
import com.p5.adoptions.repository.repositoryInterfaces.UserRepository;
import com.p5.adoptions.services.adapters.UserAdapterDomain;
import com.p5.adoptions.services.model.UserDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDomain addUser(UserDomain userDomain) {

        User user = UserAdapterDomain.fromDomain(userDomain);
        userRepository.save(user);
        return userDomain;
    }

    public List<UserDomain> getUsers() {
        return UserAdapterDomain.toListDomain(userRepository.findAll());
    }

    public UserDomain getUser(Integer id) {
        return UserAdapterDomain.toDomain(userRepository.getOne(id));
    }
}
