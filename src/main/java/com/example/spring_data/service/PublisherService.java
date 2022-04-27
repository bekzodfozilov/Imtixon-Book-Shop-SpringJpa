package com.example.spring_data.service;

import com.example.spring_data.Dao.PublisherDao;
import com.example.spring_data.Dto.PublisherDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Repository.PublisherRepository;
import com.example.spring_data.mapping.PublisherMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public ResponseDto<Page<PublisherDto>> getAllPublisher(Integer size, Integer page) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<PublisherDao> publisherDaos = publisherRepository.findAll(pageRequest);
        List<PublisherDto> publisherDtos = publisherDaos.stream()
                .map(PublisherMapping::toDtos).collect(Collectors.toList());

        return new ResponseDto<>(true,0,"ok",new PageImpl<>(publisherDtos,publisherDaos.getPageable(),publisherDaos.getTotalElements()));
    }
}
