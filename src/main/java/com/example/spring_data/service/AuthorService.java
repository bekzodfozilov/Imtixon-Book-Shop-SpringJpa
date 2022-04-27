package com.example.spring_data.service;

import com.example.spring_data.Dao.AuthorDao;
import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Repository.AuthorRepository;
import com.example.spring_data.mapping.AuthorMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;


    public ResponseDto<Page<AuthorDto>> getAllAuthor(Integer size, Integer page) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<AuthorDao> authorDaos = authorRepository.findAll(pageRequest);
        List<AuthorDto> authorDtos = authorDaos.
                stream().
                map(AuthorMapping::toDtos).collect(Collectors.toList());

        return new ResponseDto<>(true,0,"ok",new PageImpl<>(authorDtos,authorDaos.getPageable(),authorDaos.getTotalElements()));
    }
}
