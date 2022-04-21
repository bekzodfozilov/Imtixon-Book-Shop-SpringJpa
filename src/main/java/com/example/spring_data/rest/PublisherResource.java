package com.example.spring_data.rest;

import com.example.spring_data.Dto.AuthorDto;
import com.example.spring_data.Dto.PublisherDto;
import com.example.spring_data.Dto.ResponseDto;
import com.example.spring_data.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("Publisher")
@RequiredArgsConstructor
public class PublisherResource {
    private final PublisherService publisherService;

    @GetMapping("/publisher")
    public ResponseDto<List<PublisherDto>> getPublisher(){
        return publisherService.getPublisher();
    }

    @PostMapping("/publihser")
    public ResponseDto<PublisherDto> getPublisherId(@RequestParam Integer id){
        return publisherService.getPublihserId(id);
    }

    @PostMapping("/publisher")
    public ResponseDto<PublisherDto> addPublisher(@RequestBody PublisherDto publisherDto){
        return publisherService.addPublihser(publisherDto);
    }

    @DeleteMapping("/publisher")
    public ResponseDto<PublisherDto> deletePublisher(@RequestParam Integer id){
        return publisherService.deletePublihser(id);
    }

    @PutMapping("/publihser")
    public ResponseDto<PublisherDto> updatePublisher(@RequestParam Integer id){
        return publisherService.updatePublisher(id);
    }

}
