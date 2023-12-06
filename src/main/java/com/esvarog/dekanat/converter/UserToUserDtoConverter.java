package com.esvarog.dekanat.converter;

import com.esvarog.dekanat.dto.UserDTO;
import com.esvarog.dekanat.entity.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<Users, UserDTO> {
    @Override
    public UserDTO convert(Users source) {
        return new UserDTO(
                source.getId(),
                source.getUsername(),
                source.isEnabled(),
                source.getRole(),
                source.getToken(),
                source.getTokenExpire()
        );
    }
}
