package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.Address;
import whoscared.esoftdemo.esoft.demo.models.immovables.*;
//import whoscared.esoftdemo.esoft.demo.services.ApartmentService;
//import whoscared.esoftdemo.esoft.demo.services.HouseService;
//import whoscared.esoftdemo.esoft.demo.services.LandService;
import whoscared.esoftdemo.esoft.demo.services.AddressService;
import whoscared.esoftdemo.esoft.demo.services.RealEstateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/real_estate")
public class RealEstateController {
//    private final ApartmentService apartmentService;
//    private final HouseService houseService;
//    private final LandService landService;

    @Autowired
    public RealEstateController(RealEstateService realEstateService, AddressService addressService) {
        this.realEstateService = realEstateService;
        this.addressService = addressService;
    }

    private final RealEstateService realEstateService;
    private final AddressService addressService;

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
        model.addAttribute("address", new Address());
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
                           @ModelAttribute(value = "realEstate") RealEstate realEstate,
                           @ModelAttribute(value = "address") Address address) {
        realEstate.setAddress(address);
        List<RealEstate> filtersObjects = new ArrayList<>();
        if (realEstate.getTypeOfRealEstate() == null
                && realEstate.getAddress().getStreet() == null
                && realEstate.getAddress().getCity() == null) {
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
        if (!realEstate.getAddress().getCity().isEmpty()) {
            filtersObjects.removeIf(x -> !Objects.equals(x.getAddress().getCity(), realEstate.getAddress().getCity()));
        }
        if (!realEstate.getAddress().getStreet().isEmpty()) {
            filtersObjects.removeIf(x -> !Objects.equals(x.getAddress().getStreet(), realEstate.getAddress().getStreet()));
        }

        model.addAttribute("filter", true);
        model.addAttribute("filtersObjects", filtersObjects);
        return "real_estate/real_estate_main";
    }

    @GetMapping("/new")
    public String newRealEstate(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        model.addAttribute("address", new Address());
        model.addAttribute("types", List.of(TypeOfRealEstate.APARTMENT, TypeOfRealEstate.HOUSE, TypeOfRealEstate.LAND));
        return "real_estate/real_estate_new";
    }

    @PostMapping()
    public String addRealEstate(@ModelAttribute("realEstate") RealEstate realEstate,
                                @ModelAttribute("address") Address address) {
        realEstate.toRealEstateObject(realEstate.getTypeOfRealEstate());
        addressService.save(address);
        realEstate.setAddress(address);
        realEstateService.save(realEstate);
        return "redirect:/";
    }
}
