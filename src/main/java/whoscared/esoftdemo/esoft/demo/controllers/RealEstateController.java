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
import java.util.Objects;
import java.util.stream.Collectors;


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
    public String main(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        List<RealEstate> allObjects = new ArrayList<>();
        allObjects.addAll(apartmentService.findAll());
        allObjects.addAll(houseService.findAll());
        allObjects.addAll(landService.findAll());
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
                && realEstate.getCity() == null){
            model.addAttribute("filter", false);
            return "real_estate/real_estate_main";
        }
        if (realEstate.getTypeOfRealEstate() != null) {
            switch (realEstate.getTypeOfRealEstate()) {
                case APARTMENT -> filtersObjects.addAll(apartmentService.findAll());
                case HOUSE -> filtersObjects.addAll(houseService.findAll());
                case LAND -> filtersObjects.addAll(landService.findAll());
            }
        } else {
            filtersObjects.addAll(apartmentService.findAll());
            filtersObjects.addAll(houseService.findAll());
            filtersObjects.addAll(landService.findAll());
        }
        if (!realEstate.getCity().isEmpty()){
            filtersObjects.removeIf(x -> !Objects.equals(x.getCity(), realEstate.getCity()));
        }
        if (!realEstate.getStreet().isEmpty()){
            filtersObjects.removeIf(x -> !Objects.equals(x.getStreet(), realEstate.getStreet()));
        }

        model.addAttribute("filter", true);
        model.addAttribute("filtersObjects", filtersObjects);
        return "real_estate/real_estate_main";
    }

    @GetMapping("/new")
    public String newRealEstate(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        List<TypeOfRealEstate> types = List.of(TypeOfRealEstate.APARTMENT, TypeOfRealEstate.HOUSE, TypeOfRealEstate.LAND);
        model.addAttribute("types", types);
        return "real_estate/real_estate_new";
    }

    @PostMapping()
    public String addRealEstate(@ModelAttribute("realEstate") RealEstate realEstate) {
        switch (realEstate.getTypeOfRealEstate()) {
            case APARTMENT -> apartmentService.save(new Apartment(realEstate));
            case HOUSE -> houseService.save(new House(realEstate));
            case LAND -> landService.save(new Land(realEstate));
        }
        return "redirect:/";
    }
}
