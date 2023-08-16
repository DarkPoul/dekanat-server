package com.esvarog.dekanat.controller;

import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.service.UserInBaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserInBaseService userInBaseService;

    @PostMapping("/user/create")
    public ResponseEntity<Users> create(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userInBaseService.create(dto), HttpStatus.OK);
    }

    @GetMapping("/user/reedAll")
    public ResponseEntity<List<Users>> reedAll() {
        return new ResponseEntity<>(userInBaseService.readAll(), HttpStatus.OK);
    }

    @PutMapping("/user/update")
    public ResponseEntity<Users> update(@RequestBody Users users) {
        return new ResponseEntity<>(userInBaseService.update(users), HttpStatus.OK);
    }

    @DeleteMapping("/user/delete/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        userInBaseService.delete(id);
        return HttpStatus.OK;
    }
}
