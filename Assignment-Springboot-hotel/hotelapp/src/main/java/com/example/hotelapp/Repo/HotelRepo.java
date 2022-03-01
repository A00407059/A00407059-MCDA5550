package com.example.hotelapp.Repo;

import com.example.hotelapp.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, Long> {
}
