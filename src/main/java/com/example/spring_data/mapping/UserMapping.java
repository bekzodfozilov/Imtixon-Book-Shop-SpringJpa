package com.example.spring_data.mapping;

import com.example.spring_data.Dao.User;
import com.example.spring_data.Dto.UserDto;

public class UserMapping {
    public static UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getAccount(),
                user.getPhonenumber(),
                user.getPassword(),
                user.getUsername()
        );
    }
    public static User toDao(UserDto userDto){
        return new User(
               userDto.getId(),
                userDto.getFirstname(),
               userDto.getLastname(),
               userDto.getAccount(),
               userDto.getPhonenumber(),
               userDto.getPassword(),
               userDto.getUsername()
        );
    }
}
