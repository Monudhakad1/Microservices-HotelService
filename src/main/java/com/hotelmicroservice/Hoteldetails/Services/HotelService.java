package com.hotelmicroservice.Hoteldetails.Services;

import com.hotelmicroservice.Hoteldetails.Entity.Dto.HotelDto;

import java.util.List;

public interface HotelService {

    // create
    HotelDto createHotel(HotelDto hotelDto);

    List<HotelDto> getAllHotels();

    HotelDto findHotelById(String id);

    HotelDto updateHotel(HotelDto hotelDto);


}

