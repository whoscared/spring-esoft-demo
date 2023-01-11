package whoscared.esoftdemo.esoft.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import whoscared.esoftdemo.esoft.demo.models.Address;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.services.AddressService;
import whoscared.esoftdemo.esoft.demo.services.ClientService;
import whoscared.esoftdemo.esoft.demo.services.DemandService;
import whoscared.esoftdemo.esoft.demo.services.RealtorService;
import whoscared.esoftdemo.esoft.demo.utils.validator.DemandValidator;

@Controller
@RequestMapping("/demand")
public class DemandController {

    private final DemandService demandService;
    private final DemandValidator demandValidator;
    private final AddressService addressService;
    private final ClientService clientService;
    private final RealtorService realtorService;

    @Autowired
    public DemandController(DemandService demandService, DemandValidator demandValidator, AddressService addressService, ClientService clientService, RealtorService realtorService) {
        this.demandService = demandService;
        this.demandValidator = demandValidator;
        this.addressService = addressService;
        this.clientService = clientService;
        this.realtorService = realtorService;
    }

    @GetMapping()
    public String mainDemand(Model model) {
        demandService.findAll();
        model.addAttribute("demandList", demandService.findAll());
        return "demand/demand_main";
    }

    @GetMapping("/new")
    public String newDemand(Model model) {
        model.addAttribute("clientList", clientService.allClients());
        model.addAttribute("realtorList", realtorService.allRealtors());
        model.addAttribute("demand", new Demand());
        model.addAttribute("address", new Address());
        return "demand/demand_new";
    }

    @PostMapping()
    public String saveDemand(@ModelAttribute(value = "demand") @Valid Demand demand,
                             BindingResult bindingResultDemand,
                             @ModelAttribute(value = "address") @Valid Address address,
                             BindingResult bindingResultAddress) {
        demandValidator.validate(demand, bindingResultDemand);
        if (bindingResultDemand.hasErrors() || bindingResultAddress.hasErrors()) {
            return "demand/demand_new";
        }
        addressService.save(address);
        demand.setAddress(address);
        demandService.save(demand);
        return "redirect:/";
    }
}
