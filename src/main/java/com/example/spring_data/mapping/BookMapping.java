package com.example.spring_data.mapping;

import com.example.spring_data.Dao.BookDao;
import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.BookDto;
import com.example.spring_data.Dto.PublisherDto;

public class BookMapping {
    public static BookDto toDto(BookDao bookDao){
        AuthorDto authorDto = AuthorMapping.toDto(bookDao.getAuthorDao());
        PublisherDto publisherDto = PublisherMapping.toDto(bookDao.getPublisherDao());
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
    public static BookDto toDtos(BookDao bookDao){
        PublisherDto publisherDto = PublisherMapping.toDto(bookDao.getPublisherDao());
        return new BookDto(
                bookDao.getId(),
                bookDao.getNameUZ(),
                bookDao.getCost(),
                bookDao.getPublishedDate(),
                bookDao.getPage_count(),
                bookDao.getGenre(),
                publisherDto
        );
    }
   public static BookDto toDtoss(BookDao bookDao){
      AuthorDto authorDto = AuthorMapping.toDto(bookDao.getAuthorDao());
       return new BookDto(
               bookDao.getId(),
               bookDao.getNameUZ(),
               bookDao.getCost(),
               bookDao.getPublishedDate(),
               bookDao.getPage_count(),
               authorDto,
               bookDao.getGenre()

       );
   }
}
