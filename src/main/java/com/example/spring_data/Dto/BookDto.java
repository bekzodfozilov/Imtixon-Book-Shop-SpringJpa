package com.example.spring_data.Dto;

import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dao.PublisherDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto{

    private Integer id;

    private String nameuz;

    private BigDecimal cost;

    private String published_date;

    private Integer page_count;

    private AuthorDto authorDto;

    private String genre;

    private PublisherDto publisherDto;


    public BookDto(Integer id, String nameuz, BigDecimal cost, String published_date, Integer page_count, String genre, PublisherDto publisherDto) {
        this.id = id;
        this.nameuz = nameuz;
        this.cost = cost;
        this.published_date = published_date;
        this.page_count = page_count;
        this.genre = genre;
        this.publisherDto = publisherDto;
    }

    public BookDto(Integer id, String nameuz, BigDecimal cost, String published_date, Integer page_count, AuthorDto authorDto, String genre) {
        this.id = id;
        this.nameuz = nameuz;
        this.cost = cost;
        this.published_date = published_date;
        this.page_count = page_count;
        this.authorDto = authorDto;
        this.genre = genre;
    }
}
