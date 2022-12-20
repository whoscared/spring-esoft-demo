package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.immovables.TypeOfRealEstate;
import whoscared.esoftdemo.esoft.demo.services.ApartmentService;
import whoscared.esoftdemo.esoft.demo.services.HouseService;
import whoscared.esoftdemo.esoft.demo.services.LandService;


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
}
