package whoscared.esoftdemo.esoft.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import whoscared.esoftdemo.esoft.demo.models.Address;
import whoscared.esoftdemo.esoft.demo.models.immovables.RealEstate;
import whoscared.esoftdemo.esoft.demo.models.people.Person;
import whoscared.esoftdemo.esoft.demo.search.SearchClientsAndRealtors;
import whoscared.esoftdemo.esoft.demo.search.SearchRealEstate;
//import whoscared.esoftdemo.esoft.demo.search.SearchRealEstate;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final SearchClientsAndRealtors searchClientsAndRealtors;
    private final SearchRealEstate searchRealEstate;



    @Autowired
    public SearchController(SearchClientsAndRealtors searchClientsAndRealtors, SearchRealEstate searchRealEstate) {
        this.searchClientsAndRealtors = searchClientsAndRealtors;
        this.searchRealEstate = searchRealEstate;
    }

    @PostMapping()
    public String search(Model model,
                         @ModelAttribute("person") Person person) {
        List<Person> resultOfSearch = searchClientsAndRealtors.searchPersons(person);
        model.addAttribute("personList", resultOfSearch);
        return "search/search_person";
    }

    @GetMapping()
    public String search(Model model) {
        model.addAttribute("person", new Person());
        return "search/search_person";
    }

    @PostMapping("/real_estate")
    public String searchRealEstate(Model model,
                                   @ModelAttribute("realEstate") RealEstate realEstate,
                                   @ModelAttribute("address") Address address) {
        realEstate.setAddress(address);
        List<RealEstate> resultOfSearch = searchRealEstate.searchRealEstates(realEstate);
        model.addAttribute("objectsList", resultOfSearch);
        return "search/search_real_estate";
    }

    @GetMapping("/real_estate")
    public String searchRealEstate(Model model) {
        model.addAttribute("realEstate", new RealEstate());
        model.addAttribute("address", new Address());
        return "search/search_real_estate";
    }

}
