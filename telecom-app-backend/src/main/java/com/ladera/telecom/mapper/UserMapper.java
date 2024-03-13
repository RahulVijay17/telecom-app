package com.ladera.telecom.mapper;

import com.ladera.telecom.dto.UserDto;
import com.ladera.telecom.model.User;

import java.sql.Date;

public class UserMapper {

    public static UserDto mapToUserDto(User user, UserDto userDto) {
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setPwd(user.getPwd());
            userDto.setRole(user.getRole());
            userDto.setMobileNumber(user.getMobileNumber());
            return userDto;
    }

    public static User mapToUser(UserDto userDto, User user) {
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPwd(userDto.getPwd());
            user.setRole(userDto.getRole());
            user.setMobileNumber(userDto.getMobileNumber());
            return user;
    }
}
