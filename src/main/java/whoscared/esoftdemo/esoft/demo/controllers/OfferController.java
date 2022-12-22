package whoscared.esoftdemo.esoft.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import whoscared.esoftdemo.esoft.demo.models.offer.Offer;
import whoscared.esoftdemo.esoft.demo.services.ClientService;
import whoscared.esoftdemo.esoft.demo.services.OfferService;
import whoscared.esoftdemo.esoft.demo.services.RealtorService;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final ClientService clientService;
    private final RealtorService realtorService;
    private final OfferService offerService;

    @Autowired
    public OfferController(ClientService clientService, RealtorService realtorService, OfferService offerService) {
        this.clientService = clientService;
        this.realtorService = realtorService;
        this.offerService = offerService;
    }

    @GetMapping("/new")
    public String newOffer (Model model){
        model.addAttribute("offer", new Offer());
        model.addAttribute("clientList", clientService.findWithoutOffer());
        model.addAttribute("realtorList", realtorService.findWithoutOffer());
        return null;
    }

    @PostMapping("")
    public String saveOffer (@ModelAttribute("offer") Offer offer){
        return null;
    }

}
