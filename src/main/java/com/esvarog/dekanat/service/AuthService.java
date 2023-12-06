package com.esvarog.dekanat.service;

import com.esvarog.dekanat.converter.UserToUserDtoConverter;
import com.esvarog.dekanat.dto.MyUserPrincipal;
import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import com.esvarog.dekanat.security.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtProvider jwtProvider;
    private final JwtService jwtService;
    private final UserToUserDtoConverter userToUserDtoConverter;

    public AuthService(JwtProvider jwtProvider, JwtService jwtService, UserToUserDtoConverter userToUserDtoConverter) {
        this.jwtProvider = jwtProvider;
        this.jwtService = jwtService;
        this.userToUserDtoConverter = userToUserDtoConverter;
    }

    public Map<String, Object> getLoginInfo(Authentication authentication) {
        MyUserPrincipal principal = (MyUserPrincipal) authentication.getPrincipal();
        Users user = principal.getUser();
        UserDTO userDTO =  this.userToUserDtoConverter.convert(user);

        String token = this.jwtService.getTokenByUsername(user.getUsername());

        if(token != null) {
            Map<String, Object> loginResultMap = new HashMap<>();
            loginResultMap.put("userInfo", userDTO);
            loginResultMap.put("token", token);

            return loginResultMap;
        }
        try{
            token = this.jwtProvider.createToken(authentication);
        } catch (Exception e) {
            e.fillInStackTrace();
        }



        Map<String, Object> loginResultMap = new HashMap<>();
        loginResultMap.put("userInfo", userDTO);
        loginResultMap.put("token", token);

        return loginResultMap;
    }
}