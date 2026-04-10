package com.hotelmicroservice.Hoteldetails.Mapper;

import com.hotelmicroservice.Hoteldetails.Entity.Dto.HotelDto;
import com.hotelmicroservice.Hoteldetails.Entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelDto toDto(Hotel hotel);

    @Mapping(target = "id", ignore = true) // important for create
    Hotel toEntity(HotelDto dto);
}
