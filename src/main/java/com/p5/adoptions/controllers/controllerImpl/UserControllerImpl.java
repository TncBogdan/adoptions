package com.p5.adoptions.controllers.controllerImpl;

import com.p5.adoptions.controllers.adapters.UserAdapterDTO;
import com.p5.adoptions.controllers.dto.UserDTO;
import com.p5.adoptions.services.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserControllerImpl {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(UserAdapterDTO.toListDTO(userService.getUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(UserAdapterDTO.toDTO(userService.getUser(id)));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        var userForService = UserAdapterDTO.fromDTO(userDTO);
        userService.addUser(userForService);
        var userForReturn = UserAdapterDTO.toDTO(userForService);
        return ResponseEntity.ok(userForReturn);
    }
}
