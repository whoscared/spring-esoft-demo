package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@Controller
@RequestMapping("/demand")
public class DemandController {

    private final DemandService demandService;
    private final AddressService addressService;
    private final ClientService clientService;

    private final RealtorService realtorService;

    @Autowired
    public DemandController(DemandService demandService, AddressService addressService, ClientService clientService, RealtorService realtorService) {
        this.demandService = demandService;
        this.addressService = addressService;
        this.clientService = clientService;
        this.realtorService = realtorService;
    }

    @GetMapping("/new")
    public String newDemand (Model model){
        model.addAttribute("clientList", clientService.allClients());
        model.addAttribute("realtorList", realtorService.allRealtors());
        model.addAttribute("demand", new Demand());
        model.addAttribute("address", new Address());
        return "demand/demand_new";
    }

    @PostMapping()
    public String saveDemand (@ModelAttribute (value = "demand") Demand demand,
                              @ModelAttribute(value = "address") Address address){
        addressService.save(address);
        demand.setAddress(address);
        demandService.save(demand);
        return "redirect:/";
    }
}