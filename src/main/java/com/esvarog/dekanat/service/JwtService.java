package com.esvarog.dekanat.service;

import com.esvarog.dekanat.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;
    private final UserService userService;

    @Autowired
    public JwtService(JwtEncoder jwtEncoder, UserService userService) {
        this.jwtEncoder = jwtEncoder;
        this.userService = userService;
    }

//    public String createToken(Authentication authentication){
//
//        String token = this.getTokenByUsername(authentication.getName());
//        if(token != null) {
//            return token;
//        }
//
//        Instant now = Instant.now();
//        long expiresIn = 2;
//        String authorities = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//        JwtClaimsSet claims = JwtClaimsSet.builder()
//                .issuer("self")
//                .issuedAt(now)
//                .expiresAt(now.plus(expiresIn, ChronoUnit.HOURS))
//                .subject(authentication.getName())
//                .claim("authorities", authorities)
//                .build();
//
//        Users user = new Users();
//        UserDetails userDetails = this.userService.loadUserByUsername(authentication.getName());
//        user.setId(this.userService.findByUsername(userDetails.getUsername()).getId());
//        user.setEnabled(userDetails.isEnabled());
//        user.setPassword(userDetails.getPassword());
//        user.setRole(userDetails.getAuthorities().toArray()[0].toString());
//        user.setUsername(userDetails.getUsername());
//        user.setToken(this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
//        user.setTokenExpire(claims.getExpiresAt());
//        this.userService.save(user);
//
//
//
//
//        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
//    }

    public String getTokenByUsername(String username) {
        // Отримайте токен із бази даних за іменем користувача
        Users user = new Users();
        UserDetails userPrincipal = this.userService.loadUserByUsername(username);


        user.setEnabled(userPrincipal.isEnabled());
        user.setPassword(userPrincipal.getPassword());
        user.setRole(userPrincipal.getAuthorities().toArray()[0].toString());
        user.setUsername(userPrincipal.getUsername());
        user.setToken(this.userService.findByUsername(username).getToken());
        user.setTokenExpire(this.userService.findByUsername(username).getTokenExpire());


        return (user.getTokenExpire() != null && user.getTokenExpire().isAfter(Instant.now()))
                ? user.getToken()
                : null;
    }

    // Логіка отримання токена з запиту
    public String extractToken(HttpServletRequest request) {
        // Отримайте токен із заголовка запиту
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public boolean validateToken(Instant time) {
        // Перевірте, чи токен дійсний
        return time.isAfter(Instant.now());
    }

    public UserDetails loadUserByUsername(String name) {
        return this.userService.loadUserByUsername(name);
    }

    public Users findByUsername(String username) {
        return this.userService.findByUsername(username);
    }
}

