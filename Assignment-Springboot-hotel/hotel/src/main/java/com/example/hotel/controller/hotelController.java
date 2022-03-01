package com.example.hotel.controller;

import com.example.hotel.models.Hotel;
import com.example.hotel.repo.HotelRepo;
import com.example.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class hotelController {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private HotelService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Hotel> listhotel = service.listAll();
        model.addAttribute("listhotel", listhotel);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("hotel") Hotel hote){
        service.save(hote);
        return "redirect:/";
    }

    @GetMapping("/hello")
    public String sayHi() {
        return "Hi";

    }

    @GetMapping(value ="/hotels")
    public List<Hotel> getHotels(){
        return hotelRepo.findAll();
    }

    @PostMapping(value ="/sav1")
    public String saveHotel (@RequestBody Hotel hotel){
        hotelRepo.save(hotel);
        return "Saved";
    }
}
