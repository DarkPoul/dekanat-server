package com.esvarog.dekanat.controller.converter;

import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUserConverter implements Converter<UserDTO, Users> {

    @Override
    public Users convert(UserDTO source) {
        Users user = new Users();
        user.setUsername(source.getUsername());
        user.setEnabled(source.isEnabled());
        user.setRole(source.getRole());
        return user;
    }
}
