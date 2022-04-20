package com.example.spring_data.mapping;

import com.example.spring_data.Dao.PublisherDao;
import com.example.spring_data.Dto.PublisherDto;

public class PublisherMapping {

    public static PublisherDto toDto(PublisherDao publisherDao) {
        return new PublisherDto(
                publisherDao.getId(),
                publisherDao.getName(),
                publisherDao.getAdres_id()
        );

    }

    public static PublisherDao toDao(PublisherDto publisherDto) {
        return new PublisherDao(
                publisherDto.getName(),
                publisherDto.getAdres_id()
        );
    }
}
