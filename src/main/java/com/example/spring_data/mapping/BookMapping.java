package com.example.spring_data.mapping;

import com.example.spring_data.Dao.BookDao;
import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.BookDto;
import com.example.spring_data.Dto.PublisherDto;


public class BookMapping {

    public static BookDto toDto(BookDao bookDao , AuthorDto authorDto , PublisherDto publisherDto) {
        return new BookDto(
                bookDao.getId(),
                bookDao.getNameUZ(),
                bookDao.getCost(),
                bookDao.getPublishedDate(),
                bookDao.getPage_count(),
                authorDto,
                bookDao.getGenre(),
                publisherDto

        );
    }

    public static BookDao toDao(BookDto bookDto) {
        return new BookDao(
                bookDto.getId(),
                bookDto.getNameuz(),
                bookDto.getCost(),
                bookDto.getPublished_date(),
                bookDto.getPage_count(),
                bookDto.getAuthorDto().getId(),
                bookDto.getGenre(),
                bookDto.getPublisherDto().getId()
                );
    }
}
