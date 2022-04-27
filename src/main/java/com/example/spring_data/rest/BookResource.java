package com.example.spring_data.rest;

import com.example.spring_data.Dto.BookDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookResource {

    private final BookService bookService;

    @GetMapping("/get-all")
    public ResponseDto<Page<BookDto>> getAllBooks(@RequestParam Integer size ,@RequestParam Integer page){
       return bookService.getAllBooks(size,page);
    }
}
