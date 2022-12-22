package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.immovables.*;
//import whoscared.esoftdemo.esoft.demo.services.ApartmentService;
//import whoscared.esoftdemo.esoft.demo.services.HouseService;
//import whoscared.esoftdemo.esoft.demo.services.LandService;
import whoscared.esoftdemo.esoft.demo.services.RealEstateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/real_estate")
public class RealEstateController {
//    private final ApartmentService apartmentService;
//    private final HouseService houseService;
//    private final LandService landService;

    @Autowired
    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    private final RealEstateService realEstateService;

//    @Autowired
//    public RealEstateController(ApartmentService apartmentService, HouseService houseService, LandService landService, RealEstateService realEstateService) {
//        this.apartmentService = apartmentService;
//        this.houseService = houseService;
//        this.landService = landService;
//        this.realEstateService = realEstateService;
//    }


    @GetMapping()
    public String main(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        List<RealEstate> allObjects = new ArrayList<>(realEstateService.findAll());
//        allObjects.addAll(apartmentService.findAll());
//        allObjects.addAll(houseService.findAll());
//        allObjects.addAll(landService.findAll());
        model.addAttribute("allObjects", allObjects);
        model.addAttribute("filter", false);
        return "real_estate/real_estate_main";
    }

    @PostMapping("/filter")
    public String mainPost(Model model,
                           @ModelAttribute(value = "realEstate") RealEstate realEstate) {
        List<RealEstate> filtersObjects = new ArrayList<>();
        if (realEstate.getTypeOfRealEstate() == null
                && realEstate.getStreet() == null
                && realEstate.getCity() == null) {
            model.addAttribute("filter", false);
            return "real_estate/real_estate_main";
        }
        if (realEstate.getTypeOfRealEstate() != null) {
            switch (realEstate.getTypeOfRealEstate()) {
                case APARTMENT ->
                        filtersObjects.addAll(realEstateService.findByTypeOfRealEstate(TypeOfRealEstate.APARTMENT));
                case HOUSE -> filtersObjects.addAll(realEstateService.findByTypeOfRealEstate(TypeOfRealEstate.HOUSE));
                case LAND -> filtersObjects.addAll(realEstateService.findByTypeOfRealEstate(TypeOfRealEstate.LAND));
            }
        } else {
            filtersObjects.addAll(realEstateService.findAll());
        }
        if (!realEstate.getCity().isEmpty()) {
            filtersObjects.removeIf(x -> !Objects.equals(x.getCity(), realEstate.getCity()));
        }
        if (!realEstate.getStreet().isEmpty()) {
            filtersObjects.removeIf(x -> !Objects.equals(x.getStreet(), realEstate.getStreet()));
        }

        model.addAttribute("filter", true);
        model.addAttribute("filtersObjects", filtersObjects);
        return "real_estate/real_estate_main";
    }

    @GetMapping("/new")
    public String newRealEstate(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        //List<TypeOfRealEstate> types = List.of(TypeOfRealEstate.APARTMENT, TypeOfRealEstate.HOUSE, TypeOfRealEstate.LAND);
        model.addAttribute("types", List.of(TypeOfRealEstate.APARTMENT, TypeOfRealEstate.HOUSE, TypeOfRealEstate.LAND));
        return "real_estate/real_estate_new";
    }

    @PostMapping()
    public String addRealEstate(@ModelAttribute("realEstate") RealEstate realEstate) {
        realEstate.toRealEstateObject(realEstate.getTypeOfRealEstate());
        realEstateService.save(realEstate);
        return "redirect:/";
    }
}
