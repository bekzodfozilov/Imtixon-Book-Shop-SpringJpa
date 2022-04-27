package com.example.spring_data.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AuthorDto {

    private Integer id;

    private  String brithdate;

    private String firstname;

    private String lastname;

    private List<BookDto> bookDtos;

    public AuthorDto(Integer id, String brithdate, String firstname, String lastname) {
        this.id = id;
        this.brithdate = brithdate;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public AuthorDto(Integer id, String brithdate, String firstname, String lastname, List<BookDto> bookDtos) {
        this.id = id;
        this.brithdate = brithdate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.bookDtos = bookDtos;
    }

}
