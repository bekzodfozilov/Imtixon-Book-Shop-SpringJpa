package com.example.spring_data.mapping;

import com.example.spring_data.Dao.UserDao;
import com.example.spring_data.Dto.UserDto;

public class UserMapping {
    public static UserDto toDto(UserDao userDao){
        return new UserDto(
                userDao.getId(),
                userDao.getFirstname(),
                userDao.getLastname(),
                userDao.getAccount(),
                userDao.getPhonenumber(),
                userDao.getPassword(),
                userDao.getUsername()
        );
    }
    public static UserDao toDao(UserDto userDto){
        return new UserDao(
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
