package com.example.spring_data.service;
import com.example.spring_data.Dao.BookDao;
import com.example.spring_data.Dto.BookDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.Repository.BookRepository;
import com.example.spring_data.mapping.BookMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public ResponseDto<Page<BookDto>> getAllBooks(Integer size, Integer page) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<BookDao> bookDaos = bookRepository.findAll(pageRequest);
        List<BookDto> authorDtos = bookDaos.stream().
                map(BookMapping::toDto).
                collect(Collectors.
                        toList());
        return new ResponseDto<>(true,0,"ok",new PageImpl<>(authorDtos,bookDaos.getPageable(),bookDaos.getTotalElements()));

    }
}
