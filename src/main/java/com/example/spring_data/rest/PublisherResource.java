package com.example.spring_data.rest;

import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.PublisherDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Publisher")
@RequiredArgsConstructor
public class PublisherResource {
    private final PublisherService publisherService;

    @GetMapping("/get-all-publihser")
    public ResponseDto<Page<PublisherDto>> getAllPublisher(@RequestParam(defaultValue = "20")Integer size , @RequestParam(defaultValue = "0")
                                                           Integer page){
        return publisherService.getAllPublisher(size,page);
    }

}
