package com.p5.adoptions.security;

import com.p5.adoptions.repository.UserRepository;
import com.p5.adoptions.repository.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MyUserDetailService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByEmail(userName);

        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(userName);
        }

        return new UserPrincipal(userOptional.get());
    }

    @Bean
    private CommandLineRunner setUpDefaultUser() {
        return args -> {
            final String defaultEmail = "animalshelter@pentastagiu.io";
            final String defaultPassword = "password";

            Optional<User> defaultUser = userRepository.findByEmail(defaultEmail);

            if (!defaultUser.isPresent()) {
                userRepository.save(new User()
                        .setEmail(defaultEmail)
                        .setPassword(passwordEncoder.encode(defaultPassword)));
            }
        };
    }
}
