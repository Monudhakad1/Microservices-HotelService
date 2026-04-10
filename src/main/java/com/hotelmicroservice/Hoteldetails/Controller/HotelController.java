package com.hotelmicroservice.Hoteldetails.Controller;

import com.hotelmicroservice.Hoteldetails.Entity.Dto.HotelDto;
import com.hotelmicroservice.Hoteldetails.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // CREATE HOTEL
    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
        HotelDto createdHotel = hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }

    // GET ALL HOTELS
    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        List<HotelDto> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    // GET HOTEL BY ID
    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable String id) {
        HotelDto hotel = hotelService.findHotelById(id);
        return ResponseEntity.ok(hotel);
    }

    // UPDATE HOTEL
    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> updateHotel(
            @PathVariable String id, // URL path
            @RequestBody HotelDto hotelDto //json
    ) {
        hotelDto.setId(id);
        HotelDto updatedHotel = hotelService.updateHotel(hotelDto);
        return ResponseEntity.ok(updatedHotel);
    }
}