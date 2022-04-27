package com.example.spring_data.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDto {

    private Integer id;

    private String name;

    private AddressDto addressDto;

   private List<BookDto> bookDtos;

    public PublisherDto(Integer id, String name, AddressDto addressDto) {
        this.id = id;
        this.name = name;
        this.addressDto = addressDto;
    }
}
