package com.example.hotel.service;
import java.util.List;

import com.example.hotel.models.Hotel;
import com.example.hotel.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepo repo;
    public List<Hotel> listAll() {
        return repo.findAll();
    }

    public void save(Hotel std) {
        repo.save(std);
    }
}
