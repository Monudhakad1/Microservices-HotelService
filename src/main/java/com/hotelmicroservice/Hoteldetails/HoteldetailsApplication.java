package com.hotelmicroservice.Hoteldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HoteldetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoteldetailsApplication.class, args);
	}

}
