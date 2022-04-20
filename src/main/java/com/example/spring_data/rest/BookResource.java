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
//    public ResponseDto<List<BookDto>>getAll(@RequestParam Integer size, @RequestParam Integer page){
//        return bookService.getAllBooks(size,page);
//}
    public ResponseDto<List<BookDto>> getAll() {
        return bookService.getAllBooks();
    }

    @PostMapping("/get-id")
    public ResponseDto<BookDto> getById(@RequestParam Integer id) {
        return bookService.getById(id);
    }

    @DeleteMapping("delede-id")
    public ResponseDto<BookDto> delete(@RequestParam Integer id) {
        return bookService.deledeId(id);
    }

    @PostMapping("/insert")
    public ResponseDto<BookDto> insert(@RequestBody BookDto bookDto) {
        return bookService.insert(bookDto);
    }

    @PostMapping("/insert-all")
    public ResponseDto<BookDto> inserAll(@RequestBody BookDto bookDto) {
        return bookService.insertAll(bookDto);
    }
    @PostMapping("/update")
    public ResponseDto<BookDto> update(@RequestBody BookDto bookDto){
        return bookService.update(bookDto);
    }
}
