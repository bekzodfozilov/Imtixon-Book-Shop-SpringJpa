package com.example.spring_data.Dto;

import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dao.PublisherDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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



}
