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

    @GetMapping("/get")
    public ResponseDto<List<AuthorDto>> getAuthor(){
        return authorService.getAuthor();
    }

    @PostMapping("/author-get-id")
    public ResponseDto<AuthorDto> getByAuthorId(@RequestParam Integer id){
        return authorService.getByauthorId(id);
    }

    @PostMapping("/author-add")
    public ResponseDto<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto){
        return authorService.addaythor(authorDto);
    }

    @DeleteMapping("/delete-author-id")
    public ResponseDto<AuthorDto> deleteAuthor(@RequestParam Integer id){
        return authorService.deletaAuthor(id);
    }

    @PutMapping("/update-author-id")
    public ResponseDto<AuthorDto> updateAuthor(@RequestParam Integer id){
        return authorService.updateAuthor(id);
    }
}
