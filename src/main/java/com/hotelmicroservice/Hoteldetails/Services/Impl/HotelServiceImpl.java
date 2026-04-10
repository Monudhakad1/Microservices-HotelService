package com.hotelmicroservice.Hoteldetails.Services.Impl;

import com.hotelmicroservice.Hoteldetails.Entity.Hotel;
import com.hotelmicroservice.Hoteldetails.Entity.Dto.HotelDto;
import com.hotelmicroservice.Hoteldetails.ExceptionHandle.ResourceNotFoundException;
import com.hotelmicroservice.Hoteldetails.Mapper.HotelMapper;
import com.hotelmicroservice.Hoteldetails.Repositories.HotelRepo;
import com.hotelmicroservice.Hoteldetails.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private HotelMapper hotelMapper;

    // CREATE
    @Override
    public HotelDto createHotel(HotelDto hotelDto) {

        // DTO → Entity
        Hotel hotel = hotelMapper.toEntity(hotelDto);

        // Save to DB
        Hotel savedHotel = hotelRepo.save(hotel);

        return hotelMapper.toDto(savedHotel);
    }

    // GET ALL
    @Override
    public List<HotelDto> getAllHotels() {

        List<Hotel> hotels = hotelRepo.findAll();

        return hotels.stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HotelDto findHotelById(String id) {

        Hotel hotel = hotelRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        return hotelMapper.toDto(hotel);
    }

    @Override
    public HotelDto updateHotel(HotelDto hotelDto) {

        Hotel existingHotel = hotelRepo.findById(hotelDto.getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelDto.getId()));

        existingHotel.setName(hotelDto.getName());
        existingHotel.setLocation(hotelDto.getLocation());
        existingHotel.setDescription(hotelDto.getDescription());

        Hotel updatedHotel = hotelRepo.save(existingHotel);

        return hotelMapper.toDto(updatedHotel);
    }
}