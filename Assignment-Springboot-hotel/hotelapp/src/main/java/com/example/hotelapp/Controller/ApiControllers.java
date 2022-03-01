package com.example.hotelapp.Controller;

import com.example.hotelapp.Models.Hotel;
import com.example.hotelapp.Repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private HotelRepo hotelRepo;



    @GetMapping(value="/hotel")
    public List<Hotel> getHotels() {

        return hotelRepo.findAll();
    }

    @PostMapping(value="/save1")
    public String saveHotel(@RequestBody Hotel hotel){
        hotelRepo.save(hotel);
        return "Hotel info saved";
    }
}

