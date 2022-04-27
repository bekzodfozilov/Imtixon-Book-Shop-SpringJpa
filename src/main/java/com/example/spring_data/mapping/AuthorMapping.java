package com.example.spring_data.mapping;


import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;


public class AuthorMapping {


    public static AuthorDto toDto(AuthorDao authorDao) {
        return new AuthorDto(
             authorDao.getId(),
                authorDao.getBirthdate(),
             authorDao.getFirstname(),
             authorDao.getLastname()
        );
    }
    public static AuthorDto toDtos(AuthorDao authorDao){
        List<BookDto> books = authorDao.getBookDaos().stream()
                .map(BookMapping::toDtos).collect(Collectors.toList());
        return new AuthorDto(
                authorDao.getId(),
                authorDao.getBirthdate(),
                authorDao.getFirstname(),
                authorDao.getLastname(),
                books
        );
    }
}

