package com.example.spring_data.service;

import com.example.spring_data.Dao.User;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Dto.UserDto;
import com.example.spring_data.Repository.UserRepository;
import com.example.spring_data.mapping.UserMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor

public class Userservice {

    private final UserRepository userRepository;


}
