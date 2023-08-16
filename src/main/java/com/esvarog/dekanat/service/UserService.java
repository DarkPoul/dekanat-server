package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    public final UserRepo userRepo;

    public Optional<Users> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
