package com.example.spring_data.mapping;

import com.example.spring_data.Dao.AddresDao;
import com.example.spring_data.Dto.AddressDto;

public class AddressMapping {
    public static AddressDto toDto(AddresDao addresDao) {
        return new AddressDto(
                addresDao.getId(),
                addresDao.getDistrict_id(),
                addresDao.getRegionId(),
                addresDao.getStreet()
        );
    }
}
