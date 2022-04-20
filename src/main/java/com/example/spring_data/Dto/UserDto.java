package com.example.spring_data.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Integer id;

    private String firstname;


    private String lastname;


    private Integer account;

    private String phonenumber;


    private String password;


    private String username;
}
