package com.example.spring_data.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDto {

    private Integer id;

    private String name;

    private Integer adres_id;

    public PublisherDto(String name, Integer adres_id) {
        this.name = name;
        this.adres_id = adres_id;
    }


}
