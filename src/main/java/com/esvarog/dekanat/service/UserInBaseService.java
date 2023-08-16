package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserInBaseService {

    public final PasswordEncoder passwordEncoder;
    public final UserRepo userRepo;
    public Users create(UserDTO dto){
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        return userRepo.save(Users.builder()
                .username(dto.getUsername())
                .password(encodedPassword)
                .role(dto.getRole())
                .enabled(dto.isEnabled())
                .build());
    }
    public List<Users> readAll(){
        return userRepo.findAll();
    }

    public Users update(Users users) {
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        return userRepo.save(users);
    }

    public void delete(Long id){
        userRepo.deleteById(id);
    }
}
