package com.example.spring_data.rest;

import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/author")
@RequiredArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;
    @GetMapping("/get-all-author")
    public ResponseDto<Page<AuthorDto>> getAllAuthor(@RequestParam(defaultValue = "20") Integer size ,
                                                     @RequestParam(defaultValue = "0") Integer page){
      return authorService.getAllAuthor(size,page);
    }
}
