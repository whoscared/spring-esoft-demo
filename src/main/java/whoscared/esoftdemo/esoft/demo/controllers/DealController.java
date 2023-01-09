package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.Deal;
import whoscared.esoftdemo.esoft.demo.models.DeductionsAndCommissions;
import whoscared.esoftdemo.esoft.demo.services.DealService;
import whoscared.esoftdemo.esoft.demo.services.DemandService;
import whoscared.esoftdemo.esoft.demo.services.OfferService;

@Controller
@RequestMapping("/deal")
public class DealController {

    private final DealService dealService;
    private final OfferService offerService;
    private final DemandService demandService;

    @Autowired
    public DealController(DealService dealService, OfferService offerService, DemandService demandService) {
        this.dealService = dealService;
        this.offerService = offerService;
        this.demandService = demandService;
    }

    @GetMapping()
    public String allDeals(Model model){
        model.addAttribute("dealList", dealService.findAll());
        return "deal/deal_main";
    }

    @GetMapping("/new")
    public String newDeal(Model model) {
        model.addAttribute("deal", new Deal());
        model.addAttribute("offerList", offerService.findWithoutDeal());
        model.addAttribute("demandList", demandService.findWithoutDeal());
        return "deal/deal_new";
    }

    @PostMapping()
    public String saveDeal(@ModelAttribute(name = "deal") Deal deal) {
        dealService.save(deal);
        return "redirect:/deal";

    }

    @GetMapping("/{id}")
    public String currentDeal (@PathVariable("id") Long id, Model model){
        Deal currentDeal = dealService.findById(id);
        model.addAttribute("deal", currentDeal);
        model.addAttribute("dedAndComm", new DeductionsAndCommissions(currentDeal));
        return "deal/deal_id";
    }
}
