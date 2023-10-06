package com.esvarog.dekanat.security;

import com.esvarog.dekanat.controller.converter.UserDTOToUserConverter;
import com.esvarog.dekanat.controller.converter.UserToUserDtoConverter;
import com.esvarog.dekanat.dto.MyUserPrincipal;
import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtProvider jwtProvider;
    private final UserToUserDtoConverter userToUserDtoConverter;

    public AuthService(JwtProvider jwtProvider, UserToUserDtoConverter userToUserDtoConverter) {
        this.jwtProvider = jwtProvider;
        this.userToUserDtoConverter = userToUserDtoConverter;
    }

    public Map<String, Object> getLoginInfo(Authentication authentication) {
        MyUserPrincipal principal = (MyUserPrincipal) authentication.getPrincipal();
        Users user = principal.getUser();
        UserDTO userDTO =  this.userToUserDtoConverter.convert(user);

        String token = this.jwtProvider .createToken(authentication);

        Map<String, Object> loginResultMap = new HashMap<>();
        loginResultMap.put("userInfo", userDTO);
        loginResultMap.put("token", token);

        return loginResultMap;
    }
}
