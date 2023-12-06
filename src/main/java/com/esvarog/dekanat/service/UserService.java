package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.MyUserPrincipal;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.repository.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    public final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UsersRepo usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> readAll() {
        return usersRepo.findAll();
    }

    public Users findById(Long id) {
        return usersRepo.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
    }

    @Transactional
    public Users create(Users newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return usersRepo.save(newUser);
    }
    public void save(Users user) {
        usersRepo.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new MyUserPrincipal(user);
    }

    public List<Users> reedAll() {
        return usersRepo.findAll();
    }

    public Users findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }

    public Users loadByToken(String token) {
        return usersRepo.findByToken(token);
    }
}
