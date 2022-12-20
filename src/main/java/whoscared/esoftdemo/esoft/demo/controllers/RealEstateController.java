package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.immovables.*;
import whoscared.esoftdemo.esoft.demo.services.ApartmentService;
import whoscared.esoftdemo.esoft.demo.services.HouseService;
import whoscared.esoftdemo.esoft.demo.services.LandService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/real_estate")
public class RealEstateController {
    private final ApartmentService apartmentService;
    private final HouseService houseService;
    private final LandService landService;

    @Autowired
    public RealEstateController(ApartmentService apartmentService, HouseService houseService, LandService landService) {
        this.apartmentService = apartmentService;
        this.houseService = houseService;
        this.landService = landService;
    }

    @GetMapping()
    public String main (Model model,
                        @RequestParam(value = "filter_type", required = false) boolean filterType,
                        @ModelAttribute(value = "typeOfRealEstate")TypeOfRealEstate tempType,
                        @RequestParam(value = "filter_address", required = false) boolean filterAddress,
                        @ModelAttribute(value = "address")RealEstate tempRealEstate){
        if (filterType){
            switch (tempType){
                case APARTMENT -> {
                    if (filterAddress) {
                    model.addAttribute("apartments", apartmentService.findByCityAndStreet(tempRealEstate.getCity(),
                            tempRealEstate.getCity()));
                    }
                    else {
                        model.addAttribute("apartments", apartmentService.findAll());
                    }
                }
                case HOUSE -> {
                    if (filterAddress) {
                        model.addAttribute("houses", houseService.findByCityAndStreet(tempRealEstate.getCity(),
                                tempRealEstate.getCity()));
                    }
                    else {
                        model.addAttribute("houses", houseService.findAll());
                    }
                }
                case LAND -> {
                    if (filterAddress) {
                        model.addAttribute("lands", landService.findByCityAndStreet(tempRealEstate.getCity(),
                                tempRealEstate.getCity()));
                    }
                    else {
                        model.addAttribute("lands", landService.findAll());
                    }
                }
            }
        }
        else {
            model.addAttribute("apartments",apartmentService.findAll());
            model.addAttribute("houses",houseService.findAll());
            model.addAttribute("lands",landService.findAll());

        }
        return "real_estate/real_estate_main";
    }

    @GetMapping("/new")
    public String newRealEstate(Model model){
    model.addAttribute("realEstate", new RealEstate());
    List<TypeOfRealEstate> types = List.of(TypeOfRealEstate.APARTMENT, TypeOfRealEstate.HOUSE, TypeOfRealEstate.LAND);
    model.addAttribute("types", types);
    return "real_estate/real_estate_new";
    }

    @PostMapping()
    public String addRealEstate(@ModelAttribute("realEstate") RealEstate realEstate){
        switch (realEstate.getTypeOfRealEstate()){
            case APARTMENT -> apartmentService.save(new Apartment(realEstate));
            case HOUSE -> houseService.save(new House(realEstate));
            case LAND -> landService.save(new Land(realEstate));
        }
        return "redirect:/";
    }
}
