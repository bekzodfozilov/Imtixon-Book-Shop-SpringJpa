package com.example.spring_data.rest;

import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/author")
@RequiredArgsConstructor
public class AuthorResource {

    private final AuthorService authorService;

    @GetMapping("/author")
    public ResponseDto<List<AuthorDto>> getAuthor(){
        return authorService.getAuthor();
    }

    @PostMapping("/author")
    public ResponseDto<AuthorDto> getByAuthorId(@RequestParam Integer id){
        return authorService.getByauthorId(id);
    }

    @PostMapping("/author")
    public ResponseDto<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addaythor(authorDto);
    }

    @DeleteMapping("/author")
    public ResponseDto<AuthorDto> deleteAuthor(@RequestParam Integer id){
        return authorService.deletaAuthor(id);
    }

    @PutMapping("/author")
    public ResponseDto<AuthorDto> updateAuthor(@RequestParam Integer id){
        return authorService.updateAuthor(id);
    }
}
