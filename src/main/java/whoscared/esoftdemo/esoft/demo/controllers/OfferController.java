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
import whoscared.esoftdemo.esoft.demo.services.RealEstateService;
import whoscared.esoftdemo.esoft.demo.services.RealtorService;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final ClientService clientService;
    private final RealtorService realtorService;

    private final RealEstateService realEstateService;
    private final OfferService offerService;

    @Autowired
    public OfferController(ClientService clientService, RealtorService realtorService, RealEstateService realEstateService, OfferService offerService) {
        this.clientService = clientService;
        this.realtorService = realtorService;
        this.realEstateService = realEstateService;
        this.offerService = offerService;
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("offerList", offerService.findAll());
        return "offer/offer_main";
    }

    @GetMapping("/new")
    public String newOffer(Model model) {
        model.addAttribute("offer", new Offer());
        model.addAttribute("clientList", clientService.allClients());
        model.addAttribute("realtorList", realtorService.allRealtors());
        model.addAttribute("realEstateList", realEstateService.findAll());
        System.out.println("привет");
        return "offer/offer_new";
    }

    @PostMapping()
    public String saveOffer(@ModelAttribute("offer") Offer offer) {
        System.out.println("привет");
        offerService.save(offer);
        return "redirect:/offer/main";
    }

}
