package com.example.spring_data.service;

import com.example.spring_data.Dao.PublisherDao;
import com.example.spring_data.Dto.PublisherDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Repository.PublisherRepository;
import com.example.spring_data.mapping.PublisherMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    public ResponseDto<List<PublisherDto>> getPublisher() {
        List<PublisherDao> publisherDaos = publisherRepository.findAll();
        List<PublisherDto> publisherDtos = new ArrayList<>();
        for (PublisherDao publisherDao : publisherDaos){
             publisherDtos.add(PublisherMapping.toDto(publisherDao));
        }
        return new ResponseDto<>(true,0,"ok",publisherDtos);
    }

    public ResponseDto<PublisherDto> getPublihserId(Integer id) {
        Optional<PublisherDao> publisherDao = publisherRepository.findById(id);
        if(!publisherDao.isEmpty()){
            return new ResponseDto<>(true,0,"ok",PublisherMapping.toDto(publisherDao.get()));
        }
        return new ResponseDto<>(false,-1,"Id topilmadi",null);
    }

    public ResponseDto<PublisherDto> addPublihser(PublisherDto publisherDto) {
        PublisherDao publisherDao = PublisherMapping.toDao(publisherDto);
        publisherRepository.save(publisherDao);
        return new ResponseDto<>(true,0,"ok",publisherDto);

    }

    public ResponseDto<PublisherDto> deletePublihser(Integer id) {
       Optional<PublisherDao> publisherDao = publisherRepository.findById(id);
       if(!publisherDao.isEmpty()){
           publisherRepository.delete(publisherDao.get());
           return new ResponseDto<>(true,0,"ok",PublisherMapping.toDto(publisherDao.get()));
       }
       return new ResponseDto<>(false,-1,"Id topilmadi",PublisherMapping.toDto(publisherDao.get()));
    }

    public ResponseDto<PublisherDto> updatePublisher(Integer id) {
        Optional<PublisherDao> publisherDao = publisherRepository.findById(id);
        if(!publisherDao.isEmpty()){
            publisherRepository.delete(publisherDao.get());
            return new ResponseDto<>(true,0,"Uptade",PublisherMapping.toDto(publisherDao.get()));
        }
        return new ResponseDto<>(false,-1,"xatolik",PublisherMapping.toDto(publisherDao.get()));
    }
}
