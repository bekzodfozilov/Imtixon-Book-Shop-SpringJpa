package com.example.spring_data.service;

import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Repository.AuthorRepository;
import com.example.spring_data.mapping.AuthorMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;


    public ResponseDto<List<AuthorDto>> getAuthor() {
        List<AuthorDao> authorDaos = authorRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for(AuthorDao authorDao: authorDaos){
            authorDtos.add(AuthorMapping.toDto(authorDao));
        }
        return new ResponseDto<>(true,0,"ok",authorDtos);
    }


    public ResponseDto<AuthorDto> getByauthorId(Integer id) {
       Optional<AuthorDao> authorDao = authorRepository.findById(id);
        if(id == null){
            return new ResponseDto<>(false,-1,"ok",null);
        }
        if(authorDao.isEmpty()){
            return new ResponseDto<>(false,-1,"Id topilmadi",null);
        }
        return new ResponseDto<>(
                true,0,"ok",AuthorMapping.toDto(authorDao.get())
        );
    }

    public ResponseDto<AuthorDto> addaythor(AuthorDto authorDto) {
        if(authorDto != null) {
            AuthorDao authorDao = AuthorMapping.toDao(authorDto);
            authorRepository.save(authorDao);
            return new ResponseDto<>(true,0,"insert",authorDto);
        }
        return new ResponseDto<>(false,-1,"xatolik",authorDto);

    }

    public ResponseDto<AuthorDto> deletaAuthor(Integer id) {
        if(id != null) {
            Optional<AuthorDao> authorDao = authorRepository.findById(id);
            if(!authorDao.isEmpty()){
                authorRepository.delete(authorDao.get());
                return new ResponseDto<>(true,0,"ok",AuthorMapping.toDto(authorDao.get()));
            }
            return new ResponseDto<>(false,-1,"id bazada mauvjud emas",null);
        }
        return new ResponseDto<>(false,-1,"id kiriting",null);
    }

    public ResponseDto<AuthorDto> updateAuthor(Integer id) {
       Optional<AuthorDao> authorDao = authorRepository.findById(id);
       if(!authorDao.isEmpty()){
           authorRepository.save(authorDao.get());
           return new ResponseDto<>(true,0,"update",AuthorMapping.toDto(authorDao.get()));
       }
       return new ResponseDto<>(false,-1,"id topilmadi",null);
    }












}
