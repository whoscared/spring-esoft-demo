package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.Deal;
import whoscared.esoftdemo.esoft.demo.models.DeductionsAndCommissions;
import whoscared.esoftdemo.esoft.demo.models.Demand;
import whoscared.esoftdemo.esoft.demo.models.Offer;
import whoscared.esoftdemo.esoft.demo.services.DealService;
import whoscared.esoftdemo.esoft.demo.services.DemandService;
import whoscared.esoftdemo.esoft.demo.services.OfferService;

import java.util.List;

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

    //главная страница
    @GetMapping()
    public String allDeals(Model model) {
        model.addAttribute("dealList", dealService.findAll());
        return "deal/deal_main";
    }

    //создание новой сделки
    @GetMapping("/new")
    public String newDeal(Model model) {
        model.addAttribute("deal", new Deal());
        model.addAttribute("offerList", offerService.findWithoutDeal());
        model.addAttribute("demandList", demandService.findWithoutDeal());
        return "deal/deal_new";
    }

    //получаем новую сделку из представления и сохраняем
    @PostMapping()
    public String saveDeal(@ModelAttribute(name = "deal") Deal deal) {
        dealService.save(deal);
        return "redirect:/deal";

    }

    //страница для конкретной сделки
    @GetMapping("/{id}")
    public String currentDeal(@PathVariable("id") Long id, Model model) {
        Deal currentDeal = dealService.findById(id);
        model.addAttribute("deal", currentDeal);
        model.addAttribute("dedAndComm", new DeductionsAndCommissions(currentDeal));
        return "deal/deal_id";
    }

    //страница для поиска
    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("deal", new Deal());
        model.addAttribute("demand", new Demand());
        //используем метод из сервиса - поиск потребностей, которые не участвуют в сделке
        model.addAttribute("demandList", demandService.findWithoutDeal());
        model.addAttribute("search", false);
        return "deal/deal_search";
    }

    @PostMapping("/search")
    public String searchByDemand(@ModelAttribute(name = "deal") Deal deal,
                                 Model model) {

        // метод сервиса предложений для поиска по потребностям
        List<Offer> goodOffer = offerService.findByDemand(deal.getDemand());
        model.addAttribute("offerList", goodOffer);
        model.addAttribute("search", true);
        model.addAttribute("deal", deal);
        return "deal/deal_search";
    }
}
