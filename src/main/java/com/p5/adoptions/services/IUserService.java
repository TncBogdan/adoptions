package com.p5.adoptions.services;

import com.p5.adoptions.services.model.UserDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    UserDomain get(Integer id);

    List<UserDomain> getAll();

    UserDomain add(UserDomain userDomain);
}
