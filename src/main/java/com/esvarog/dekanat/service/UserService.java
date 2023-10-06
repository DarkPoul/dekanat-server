package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.MyUserPrincipal;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.repository.UserRepo;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    public final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> reedAll(){
        return userRepo.findAll();
    }
    public Users findById(Long id){
        return this.userRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "User"));

    }
    public Users create(Users NewUser){
        NewUser.setPassword(this.passwordEncoder.encode(NewUser.getPassword()));
        return this.userRepo.save(NewUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findByUsername(username)
                .map(MyUserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found : " + username));
    }
}
