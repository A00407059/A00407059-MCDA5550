package com.example.hotelapp.Service;
import java.util.List;

import com.example.hotelapp.Models.Hotel;
import com.example.hotelapp.Repo.HotelRepo;
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
