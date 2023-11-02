package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<Users> create(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userService.create(new Users(
                userService.usersRepo.count() + 1L,
                dto.getUsername(),
                dto.getPassword(),
                dto.isEnabled(),
                dto.getRole()
        )), HttpStatus.OK);
    }

    @GetMapping("/user/reedAll")
    public ResponseEntity<List<Users>> reedAll() {
        return new ResponseEntity<>(userService.reedAll(), HttpStatus.OK);
    }
}
