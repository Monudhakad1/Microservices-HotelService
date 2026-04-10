package com.hotelmicroservice.Hoteldetails.Entity.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private String id;
    private String name;
    private String location;
    private String description;

    private List<RatingDto> ratings;
}
