
package com.example.hotelapp.Controller;

import com.example.hotelapp.Models.Hotel;
import com.example.hotelapp.Repo.HotelRepo;
import com.example.hotelapp.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private HotelRepo hotelRepo;

    @RequestMapping(value="/")
    public String index(Model model) {
        List<Hotel> listhotel = hotelRepo.findAll();
        model.addAttribute("listhotel", listhotel);
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("hotel") Hotel hote){
        hotelRepo.save(hote);
        return "redirect:/";
    }
}
