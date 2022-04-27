package com.example.spring_data.mapping;

import com.example.spring_data.Dao.BookDao;
import com.example.spring_data.Dao.PublisherDao;
import com.example.spring_data.Dto.AddressDto;
import com.example.spring_data.Dto.BookDto;
import com.example.spring_data.Dto.PublisherDto;

import java.util.List;
import java.util.stream.Collectors;

public class PublisherMapping {


    public static PublisherDto toDto(PublisherDao Entity) {
        AddressDto addressDto = AddressMapping.toDto(Entity.getAddresDao());
        return new PublisherDto(
                Entity.getId(),
                Entity.getName(),
                addressDto
        );
    }
    public static PublisherDto toDtos(PublisherDao Entity){
        List<BookDto> bookDtos = Entity.getBookDaos().stream()
                .map(BookMapping::toDtoss).collect(Collectors.toList());
        AddressDto addressDto = AddressMapping.toDto(Entity.getAddresDao());
        return new PublisherDto(
                Entity.getId(),
                Entity.getName(),
                addressDto,
                bookDtos
        );
    }
}
