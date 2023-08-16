package com.esvarog.dekanat.service;

import com.esvarog.dekanat.model.LoginResponse;
import com.esvarog.dekanat.security.JwtIssuer;
import com.esvarog.dekanat.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String username, String password){
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();
        System.out.println(principal.getAuthorities());

        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername(), roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
