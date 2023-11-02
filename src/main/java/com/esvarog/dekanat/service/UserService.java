package com.esvarog.dekanat.service;

import com.esvarog.dekanat.dto.MyUserPrincipal;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.repository.UsersRepo;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    public final UsersRepo usersRepo;
    private final PasswordEncoder passwordEncoder;
    public UserService(UsersRepo usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Users> reedAll(){
        return usersRepo.findAll();
    }
    public Users findById(Long id){
        return this.usersRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "User"));

    }
    public Users create(Users NewUser){
        NewUser.setPassword(this.passwordEncoder.encode(NewUser.getPassword()));
        return this.usersRepo.save(NewUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.usersRepo.findByUsername(username)
                .map(MyUserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found : " + username));
    }
}
