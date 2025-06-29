package com.ecom.app.mapper;

import com.ecom.app.dto.UserDto;
import com.ecom.app.entity.User;

public class UserMapper {
    public static UserDto toDto(User entity) {
        return new UserDto(
            entity.getId(),
            entity.getUsername(),
            entity.getEmail(),
            entity.getRole()
        );
    }
}