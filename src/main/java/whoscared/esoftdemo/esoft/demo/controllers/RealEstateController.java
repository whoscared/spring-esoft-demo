package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.Address;
import whoscared.esoftdemo.esoft.demo.models.immovables.*;
import whoscared.esoftdemo.esoft.demo.services.AddressService;
import whoscared.esoftdemo.esoft.demo.services.RealEstateService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/real_estate")
public class RealEstateController {

    @Autowired
    public RealEstateController(RealEstateService realEstateService, AddressService addressService) {
        this.realEstateService = realEstateService;
        this.addressService = addressService;
    }

    private final RealEstateService realEstateService;
    private final AddressService addressService;


    //главная страница - все объекты недвижимости
    @GetMapping()
    public String main(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        model.addAttribute("address", new Address());
        List<RealEstate> allObjects = new ArrayList<>(realEstateService.findAll());
        model.addAttribute("allObjects", allObjects);
        model.addAttribute("filter", false);
        return "real_estate/real_estate_main";
    }

    //получаем с формы город, улицу и тип объекта недвижимости (с помощью объекта RealEstate)
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
        // добавляем в список все ОН, подходящие по заданному типу
        if (realEstate.getTypeOfRealEstate() != null) {
            switch (realEstate.getTypeOfRealEstate()) {
                case APARTMENT ->
                        filtersObjects.addAll(realEstateService.findByTypeOfRealEstate(TypeOfRealEstate.APARTMENT));
                case HOUSE -> filtersObjects.addAll(realEstateService.findByTypeOfRealEstate(TypeOfRealEstate.HOUSE));
                case LAND -> filtersObjects.addAll(realEstateService.findByTypeOfRealEstate(TypeOfRealEstate.LAND));
            }
            // если тип не указан добавляем все
        } else {
            filtersObjects.addAll(realEstateService.findAll());
        }
        // если указан город  удаляем объекты, город которых не соответствует
        if (!realEstate.getAddress().getCity().isEmpty()) {
            filtersObjects.removeIf(x -> !Objects.equals(x.getAddress().getCity(), realEstate.getAddress().getCity()));
        }
        // если указана улица удаляем объекты, улица которых не соответствует
        if (!realEstate.getAddress().getStreet().isEmpty()) {
            filtersObjects.removeIf(x -> !Objects.equals(x.getAddress().getStreet(), realEstate.getAddress().getStreet()));
        }

        model.addAttribute("filter", true);
        // передаем в представление получившийся список
        model.addAttribute("filtersObjects", filtersObjects);
        return "real_estate/real_estate_main";
    }

    //создание нового ОН
    @GetMapping("/new")
    public String newRealEstate(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        model.addAttribute("address", new Address());
        model.addAttribute("types", List.of(TypeOfRealEstate.APARTMENT, TypeOfRealEstate.HOUSE, TypeOfRealEstate.LAND));
        return "real_estate/real_estate_new";
    }

    // сохранияем созданный ОН
    @PostMapping()
    public String addRealEstate(@ModelAttribute("realEstate") @Valid RealEstate realEstate,
                                BindingResult bindingResult,
                                @ModelAttribute("address") @Valid Address address,
                                BindingResult bindingResultAddress) {
        if (bindingResult.hasErrors() || bindingResultAddress.hasErrors()) {
            return "real_estate/real_estate_new";
        }
        realEstate.toRealEstateObject();
        addressService.save(address);
        realEstate.setAddress(address);
        realEstateService.save(realEstate);
        return "redirect:/real_estate";
    }
}
