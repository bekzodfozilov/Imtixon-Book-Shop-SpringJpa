package com.example.spring_data.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer id;
    private Integer district_id;
    private Integer region_id;
    private String street;
}
