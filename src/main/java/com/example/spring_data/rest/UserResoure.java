package com.example.spring_data.rest;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Dto.UserDto;
import com.example.spring_data.service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("user")
@RequiredArgsConstructor
public class UserResoure {

    private final Userservice userservice;

    @GetMapping("/user")
    public ResponseDto<List<UserDto>> getUser(){
        return userservice.getUser();
    }

    @PostMapping("uses")
    public ResponseDto<UserDto> getById(@RequestParam Integer id){
        return userservice.getById(id);
    }

    @PutMapping("/user")
    public ResponseDto<UserDto> updateId(@RequestParam Integer id , @RequestParam String password){
        return userservice.updateId(id,password);
    }
    @DeleteMapping("user")
    public ResponseDto<UserDto> deleteId(@RequestParam Integer id){
        return userservice.delete(id);
    }
    @PostMapping("/ user")
    public ResponseDto<UserDto> addUser(@RequestBody UserDto userDto){
        return userservice.addUser(userDto);
    }
}
