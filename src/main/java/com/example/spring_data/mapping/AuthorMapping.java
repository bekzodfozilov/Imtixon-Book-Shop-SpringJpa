package com.example.spring_data.mapping;


import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dto.AuthorDto;


public class AuthorMapping {


    public static AuthorDao toDao(AuthorDto authorDto) {
        return new AuthorDao(
                authorDto.getBrithdate(),
                authorDto.getFirstname(),
                authorDto.getLastname()
        );
    }

    public static AuthorDto toDto(AuthorDao authorDao) {
        return new AuthorDto(
                authorDao.getId(),
                authorDao.getBirthdate(),
                authorDao.getFirstname(),
                authorDao.getLastname()
        );
    }
}

