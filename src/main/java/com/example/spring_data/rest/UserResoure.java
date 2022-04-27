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


}
