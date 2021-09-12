//package com.p5.adoptions.security;
//
//import com.p5.adoptions.repository.entity.RolesEnum;
//import com.p5.adoptions.repository.entity.User;
//import com.p5.adoptions.repository.repositoryInterfaces.RoleRepository;
//import com.p5.adoptions.repository.repositoryInterfaces.UserRepository;
//import com.p5.adoptions.repository.roles.Role;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.Optional;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//    private final RoleRepository roleRepository;
//
//    public MyUserDetailService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        Optional<User> userOptional = userRepository.findByEmail(userName);
//
//        if (!userOptional.isPresent()) {
//            throw new UsernameNotFoundException(userName);
//        }
//
//        return new UserPrincipal(userOptional.get());
//    }
//
//    @Bean
//    private CommandLineRunner setUpDefaultUser() {
//        return args -> {
//            final String defaultEmail = "animalshelter@pentastagiu.io";
//            final String defaultPassword = "password";
//
//            var moderatorRole = roleRepository.findByRole(RolesEnum.ROLE_MOD).orElseGet(() -> {
//                Role newRole = new Role().setRole(RolesEnum.ROLE_MOD);
//                return roleRepository.save(newRole);
//            });
//
//            Optional<User> defaultUser = userRepository.findByEmail(defaultEmail);
//
//            if (!defaultUser.isPresent()) {
//                userRepository.save(new User()
//                        .setEmail(defaultEmail)
//                        .setPassword(passwordEncoder.encode(defaultPassword))
//                        .setUserRoles(Collections.singleton(moderatorRole)));
//            }
//        };
//    }
//}
