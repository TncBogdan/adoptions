package com.p5.adoptions.services.serviceImpl;

import com.p5.adoptions.repository.UserRepository;
import com.p5.adoptions.repository.entity.User;
import com.p5.adoptions.services.adapters.UserDomainMapper;
import com.p5.adoptions.services.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private UserDomainMapper userDomainMapper;

    public Integer addUser(UserDomain userDomain) {

        var user = userDomainMapper.fromDomain(userDomain);

        userRepository.save(user);

        return userDomain.getId();
    }

}
