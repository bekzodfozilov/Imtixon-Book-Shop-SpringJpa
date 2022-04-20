package com.example.spring_data.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private Integer id;

    private  String brithdate;

    private String firstname;

    private String lastname;

    public AuthorDto(String brithdate, String firstname, String lastname) {
        this.brithdate = brithdate;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
