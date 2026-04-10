package com.hotelmicroservice.Hoteldetails.Repositories;

import com.hotelmicroservice.Hoteldetails.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
